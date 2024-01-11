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
        return prietenieService.sendFriendRequest(user_curent, id);
    }
    @PostMapping("/api/cerere_prietenie/accept/{id}")
    public ResponseEntity<String> acceptFriendRequest(Authentication authentication, @PathVariable Long id){
        String user_email = ((DefaultOidcUser) authentication.getPrincipal()).getEmail();
        Utilizator user_curent = utilizatorService.getUtilizatorByEmail(user_email);
        return prietenieService.acceptFriendRequest(user_curent, id);
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
        return prietenieService.getReceivedRequests(user_curent);
    }

    @GetMapping("/api/afisare_inamici")
    public List<Utilizator> getEnemiesOf(Authentication authentication){
        String user_email = ((DefaultOidcUser) authentication.getPrincipal()).getEmail();
        Utilizator user_curent = utilizatorService.getUtilizatorByEmail(user_email);
        return prietenieService.getEnemiesOf(user_curent);
    }


    @PostMapping("/api/stergere_prieten/{id}")
    public ResponseEntity<String> deleteFriend(Authentication authentication, @PathVariable Long id){
        String user_email = ((DefaultOidcUser) authentication.getPrincipal()).getEmail();
        Utilizator user_curent = utilizatorService.getUtilizatorByEmail(user_email);
        return prietenieService.deleteFriend(user_curent, id);
    }

    @GetMapping("/api/afisare_pr_by_utilizatori/{id}")
    public Prietenie getPrietenieByUsers(Authentication authentication,@PathVariable Long id){
        String user_email = ((DefaultOidcUser) authentication.getPrincipal()).getEmail();
        Utilizator user_curent = utilizatorService.getUtilizatorByEmail(user_email);
        return prietenieService.getPrietenieByUsers(user_curent.getIdUtilizator(), id);
    }
    @PostMapping("/api/cerere_prietenie/reject/{id}")
    public ResponseEntity<String> rejectFriendRequest(Authentication authentication, @PathVariable Long id){
        Response response = new Response();
        String user_email = ((DefaultOidcUser) authentication.getPrincipal()).getEmail();

        Utilizator user_curent = utilizatorService.getUtilizatorByEmail(user_email);
        return prietenieService.rejectFriendRequest(user_curent, id);
    }

    public List<Utilizator> getSentRequests(Authentication authentication){
        String user_email = ((DefaultOidcUser) authentication.getPrincipal()).getEmail();
        Utilizator user_curent = utilizatorService.getUtilizatorByEmail(user_email);
        return prietenieService.getSentRequests(user_curent);
    }
}
