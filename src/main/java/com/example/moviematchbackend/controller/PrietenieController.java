package com.example.moviematchbackend.controller;

import com.example.moviematchbackend.models.entity.Prietenie;
import com.example.moviematchbackend.models.entity.StatusCerere;
import com.example.moviematchbackend.models.entity.Utilizator;
import com.example.moviematchbackend.services.prietenie_service.PrietenieService;
import com.example.moviematchbackend.services.utilizator_service.UtilizatorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class PrietenieController {

    @Autowired
    private PrietenieService prietenieService;
    @Autowired
    private UtilizatorService utilizatorService;
    //acest obiect este folosit pentru a apela metodele din clasa PrietenieService
    @Autowired
    public PrietenieController(PrietenieService prietenieService, UtilizatorService utilizatorService) {
        this.prietenieService = prietenieService;
        this.utilizatorService = utilizatorService;
    }
    //acest constructor este folosit pentru a crea un obiect de tip PrietenieController
    @GetMapping("/api/prieteni")
    public List<Prietenie> getPrietenii() {
        return this.prietenieService.getAllPrietenii();
    }
    //acest endpoint imi returneaza toate prieteniile din baza de date in format json
    @GetMapping("/api/prieteni/{id}")
    public Prietenie getPrietenieById(@PathVariable Long id) {
        return this.prietenieService.getPrietenieById(id);
    }
    //acest endpoint imi returneaza o prietenie dupa id in format json
    @PostMapping("/api/prieteni")
    public void addPrietenie(@RequestBody Long id_utilizator1, Long id_utilizator2) {
        this.prietenieService.savePrietenie(this.prietenieService.getPrietenieById(id_utilizator1));
    }
    //acest endpoint imi adauga o prietenie in baza de date
    @DeleteMapping("/api/prieteni/{id}")
    public void deletePrietenie(@PathVariable Long id) {
        this.prietenieService.deletePrietenie(this.prietenieService.getPrietenieById(id));
    }
    @PostMapping("/api/cerere_prietenie/send/{id}")
    public ResponseEntity<String> sendFriendRequest(Authentication authentication, @PathVariable Long id){
        String user_email = ((DefaultOidcUser) authentication.getPrincipal()).getEmail();
        Utilizator user_curent = utilizatorService.getUtilizatorByEmail(user_email);
        Prietenie prietenie = new Prietenie();
        Utilizator viitor_prieten = utilizatorService.getUtilizatorById(id);
        boolean checked = false;
        List<Prietenie> prietenii = prietenieService.getAllPrietenii();
        //verificam daca exista deja in asteptare o cerere in directie inversa
        for(Prietenie pr: prietenii){
            if(Objects.equals(pr.getUtilizator1().getIdUtilizator(), id) && Objects.equals(pr.getUtilizator2().getIdUtilizator(), user_curent.getIdUtilizator())){
                checked = true;
            }
            if(Objects.equals(pr.getUtilizator2().getIdUtilizator(), id) && Objects.equals(pr.getUtilizator1().getIdUtilizator(), user_curent.getIdUtilizator())){
                checked = true;
            }
        }
        if(!checked) {
            //daca utilizatorul caruia dorim sa-i trimitem cererea nu exista, eroare
            if (viitor_prieten == null) {
                return new ResponseEntity<>("Utilizatorul nu exista", HttpStatus.valueOf(404));
            } else {
                //daca utilizatorul exista, adaugam in baza de date prietenia in asteptare;
                //user1->trimite cererea, user2->accepta cererea, status = 200 = succes
                prietenie.setUtilizator1(user_curent);
                prietenie.setUtilizator2(viitor_prieten);
                prietenie.setStatusCerere(StatusCerere.IN_ASTEPTARE);
                prietenieService.savePrietenie(prietenie);
                return new ResponseEntity<>("", HttpStatus.valueOf(200));

            }
        }else{
            //daca exista deja o cerere din directia opusa -> eroare
            return new ResponseEntity<>("Exista deja o cerere de prietenie in curs.", HttpStatus.valueOf(400));
        }
    }
    @PostMapping("/api/cerere_prietenie/accept")
    public ResponseEntity<String> acceptFriendRequest(Authentication authentication, @RequestBody Long id_prietenie){
        String user_email = ((DefaultOidcUser) authentication.getPrincipal()).getEmail();
        Utilizator user_curent = utilizatorService.getUtilizatorByEmail(user_email);
        Prietenie prietenie = new Prietenie();
        Prietenie prietenie1 = prietenieService.getPrietenieById(id_prietenie);
        //verificam daca exista prietenia a carui status dorim sa-l schimbam; daca nu exista -> eroare
        if(prietenie1 == null){
            return new ResponseEntity<>("Cererea de prietenie nu exista", HttpStatus.valueOf(404));
        }else{
            //verificam daca utilizatorul care accepta cererea este cel logat
            if(prietenie1.getUtilizator2() == user_curent) {
                //cand acceptam cererea, adaugam in baza de date si o prietenie in sens invers, cu acelasi status
                prietenie1.setStatusCerere(StatusCerere.ACCEPTATA);
                prietenie.setUtilizator1(user_curent);
                prietenie.setUtilizator2(prietenie1.getUtilizator1());
                prietenie.setStatusCerere(StatusCerere.ACCEPTATA);
                prietenieService.savePrietenie(prietenie);
                return new ResponseEntity<>(HttpStatus.valueOf(200));
            }else{
                return new ResponseEntity<>("Nu puteti accepta aceasta cerere.", HttpStatus.valueOf(400));

            }
        }
    }

    @GetMapping("/api/afisare_prieteni")
    public List<Utilizator> getFriendsOf(Authentication authentication){
        String user_email = ((DefaultOidcUser) authentication.getPrincipal()).getEmail();
        Utilizator user_curent = utilizatorService.getUtilizatorByEmail(user_email);

        return prietenieService.getFriendsOf(user_curent);
    }

    @GetMapping("/api/afisare_cereri")
    public List<Utilizator> getReceivedRequests(Authentication authentication){
        String user_email = ((DefaultOidcUser) authentication.getPrincipal()).getEmail();
        Utilizator user_curent = utilizatorService.getUtilizatorByEmail(user_email);
        List<Prietenie> prietenii = prietenieService.getAllPrietenii();
        List<Utilizator> prieteniOf = new ArrayList<>();
        for(Prietenie pr: prietenii){
            if(pr.getUtilizator2() == user_curent && pr.getStatusCerere() == StatusCerere.IN_ASTEPTARE){
                prieteniOf.add(pr.getUtilizator1());
            }
        }
        return prieteniOf;
    }

    @GetMapping("/api/afisare_inamici")
    public List<Utilizator> getEnemiesOf(Authentication authentication){
        String user_email = ((DefaultOidcUser) authentication.getPrincipal()).getEmail();
        Utilizator user_curent = utilizatorService.getUtilizatorByEmail(user_email);
        List<Utilizator> users = utilizatorService.getAllUtilizatori();
        List<Utilizator> prieteniOf = getFriendsOf(authentication);
        users.removeAll(prieteniOf);
        users.remove(user_curent);
        users.removeAll(getReceivedRequests(authentication));
        users.removeAll(prietenieService.getSentRequests(user_curent));
        return users;
    }


    @PostMapping("/api/stergere_prieten")
    public ResponseEntity<String> deleteFriend(Authentication authentication, @RequestBody Long id_prietenie){
        String user_email = ((DefaultOidcUser) authentication.getPrincipal()).getEmail();
        Utilizator user_curent = utilizatorService.getUtilizatorByEmail(user_email);
        Prietenie prietenie1 = prietenieService.getPrietenieById(id_prietenie);
        //verificam daca exista prietenia pe care dorim sa o stergem
        if(prietenie1 == null){
            return new ResponseEntity<>("Cererea de prietenie nu exista",HttpStatus.valueOf(404));
        }else{
            //verificam daca utilizatorul care sterge prietenul este cel logat
            if(prietenie1.getUtilizator1() == user_curent) {
                //cand stergem un prieten, stergem si relatia in sens invers
                Prietenie pr = prietenieService.getPrietenieByUsers(prietenie1.getUtilizator2().getIdUtilizator(), user_curent.getIdUtilizator());
                prietenieService.deletePrietenie(prietenie1);
                prietenieService.deletePrietenie(pr);
                return new ResponseEntity<>(HttpStatus.valueOf(200));

            }else{
                return new ResponseEntity<>("Nu puteti sterge acest prieten.",HttpStatus.valueOf(400));

            }
        }
    }
    @PostMapping("/api/cerere_prietenie/reject")
    public ResponseEntity<String> rejectFriendRequest(Authentication authentication, @RequestBody Long id_prietenie){
        Response response = new Response();
        String user_email = ((DefaultOidcUser) authentication.getPrincipal()).getEmail();

        Utilizator user_curent = utilizatorService.getUtilizatorByEmail(user_email);
        Prietenie prietenie1 = prietenieService.getPrietenieById(id_prietenie);
        //verificam daca exista prietenia a carui status dorim sa-l schimbam; daca nu exista -> eroare
        if(prietenie1 == null){
            return new ResponseEntity<>("Cererea de prietenie nu exista",HttpStatus.valueOf(404));

        }else{
            //verificam daca utilizatorul care accepta cererea este cel logat
            if(prietenie1.getUtilizator2() == user_curent) {
                //cand respingem cererea, stergem din baza de date prietenia; nu modificam statusul
                //la respins, ca sa poata fi trimisa ulterior alta cerere
                prietenieService.deletePrietenie(prietenie1);
                return new ResponseEntity<>(HttpStatus.valueOf(200));
            }else{
                return new ResponseEntity<>("Nu puteti respinge aceasta cerere",HttpStatus.valueOf(400));

            }
        }
    }



    public List<Utilizator> getSentRequests(Authentication authentication){
        String user_email = ((DefaultOidcUser) authentication.getPrincipal()).getEmail();
        Utilizator user_curent = utilizatorService.getUtilizatorByEmail(user_email);
        return prietenieService.getSentRequests(user_curent);
    }
}
