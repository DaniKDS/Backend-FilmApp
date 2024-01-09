package com.example.moviematchbackend.services.prietenie_service;

import com.example.moviematchbackend.models.entity.Prietenie;
import com.example.moviematchbackend.models.entity.StatusCerere;
import com.example.moviematchbackend.models.entity.Utilizator;
import com.example.moviematchbackend.repositories.PrietenieRepository;
import com.example.moviematchbackend.repositories.UtilizatorRepository;
import jdk.jshell.execution.Util;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
//acea clasa care imi face legatura dintre frontend si backend

@Service
public class PrietenieService implements PrietenieServiceInterface {

    @Autowired
    //acest obiect este folosit pentru a apela metodele din clasa PrietenieRepository
    private PrietenieRepository prietenieRepository;
    @Autowired
    private UtilizatorRepository utilizatorRepository;
    //acest constructor este folosit pentru a crea un obiect de tip PrietenieService
    public PrietenieService(PrietenieRepository prietenieRepository, UtilizatorRepository utilizatorRepository) {
        this.prietenieRepository = prietenieRepository;
        this.utilizatorRepository = utilizatorRepository;
    }

    //acesta metoda imi returneaza toate prieteniile din baza de date in format json
    @Override
    public List<Prietenie> getAllPrietenii() {
        List<Prietenie> listOfPrietenii = new ArrayList<>();
        this.prietenieRepository.findAll().forEach(prietenie -> listOfPrietenii.add(prietenie));
        return listOfPrietenii;
    }
    //acesta metoda imi returneaza toate prieteniile din baza de date

    @Override
    public Prietenie getPrietenieById(Long idPrietenie) {
        return this.prietenieRepository.getPrietenieByIdPrietenie(idPrietenie);
    }
    //acesta metoda imi returneaza o prietenie dupa id in format json

    @Override
    public Prietenie savePrietenie(Prietenie prietenie) {
        return this.prietenieRepository.save(prietenie);
    }
    //acesta metoda imi adauga o prietenie in baza de date
    @Override
    public void deletePrietenie(Prietenie prietenie) {
        this.prietenieRepository.delete(prietenie);
    }
    public List<Utilizator> getSentRequests(Utilizator user_curent){
        List<Prietenie> prietenii = getAllPrietenii();
        List<Utilizator> prieteniOf = new ArrayList<>();
        for(Prietenie pr: prietenii){
            if(pr.getUtilizator1() == user_curent && pr.getStatusCerere() == StatusCerere.IN_ASTEPTARE){
                prieteniOf.add(pr.getUtilizator2());
            }
        }
        return prieteniOf;
    }
    public Prietenie getPrietenieByUsers(Long idUtil1, Long idUtil2){
        List<Prietenie> prietenii = getAllPrietenii();
        for(Prietenie prietenie:prietenii){
            if( prietenie.getUtilizator1().getIdUtilizator() == idUtil1 && prietenie.getUtilizator2().getIdUtilizator() == idUtil2){
                return prietenie;
            }
        }
        return null;
    }
    public List<Utilizator> getFriendsOf(Utilizator utilizator){
        List<Prietenie> prietenii = getAllPrietenii();
        List<Utilizator> prieteniOf = new ArrayList<>();
        for(Prietenie pr: prietenii){
            if(pr.getUtilizator1() == utilizator && pr.getStatusCerere() == StatusCerere.ACCEPTATA){
                prieteniOf.add(pr.getUtilizator2());
            }
        }
        return prieteniOf;
    }
    public ResponseEntity<String> sendFriendRequest(Utilizator user_curent, Long id){
        Prietenie prietenie = new Prietenie();
        Utilizator viitor_prieten = utilizatorRepository.getUtilizatorByIdUtilizator(id);
        boolean checked = false;
        List<Prietenie> prietenii = getAllPrietenii();
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
                savePrietenie(prietenie);
                return new ResponseEntity<>("", HttpStatus.valueOf(200));

            }
        }else{
            //daca exista deja o cerere din directia opusa -> eroare
            return new ResponseEntity<>("Exista deja o cerere de prietenie in curs.", HttpStatus.valueOf(400));
        }
    }
    public ResponseEntity<String> acceptFriendRequest(Utilizator user_curent, Long id){
        Prietenie prietenie = new Prietenie();
        Prietenie prietenie1 = getPrietenieByUsers(id, user_curent.getIdUtilizator());
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
                savePrietenie(prietenie);
                return new ResponseEntity<>(HttpStatus.valueOf(200));
            }else{
                return new ResponseEntity<>("Nu puteti accepta aceasta cerere.", HttpStatus.valueOf(400));

            }
        }
    }

    public List<Utilizator> getReceivedRequests(Utilizator user_curent){
        List<Prietenie> prietenii = getAllPrietenii();
        List<Utilizator> prieteniOf = new ArrayList<>();
        for(Prietenie pr: prietenii){
            if(pr.getUtilizator2() == user_curent && pr.getStatusCerere() == StatusCerere.IN_ASTEPTARE){
                prieteniOf.add(pr.getUtilizator1());
            }
        }
        return prieteniOf;
    }

    public List<Utilizator> getEnemiesOf(Utilizator user_curent){
        List<Utilizator> users = new ArrayList<>();
        this.utilizatorRepository.findAll().forEach(utilizator -> users.add(utilizator));
        List<Utilizator> prieteniOf = getFriendsOf(user_curent);
        users.removeAll(prieteniOf);
        users.remove(user_curent);
        users.removeAll(getReceivedRequests(user_curent));
        users.removeAll(getSentRequests(user_curent));
        return users;
    }

    public ResponseEntity<String> deleteFriend(Utilizator user_curent, Long id){
        Prietenie prietenie1 = getPrietenieByUsers(user_curent.getIdUtilizator(), id);

        //verificam daca exista prietenia pe care dorim sa o stergem
        if(prietenie1 == null){
            return new ResponseEntity<>("Cererea de prietenie nu exista",HttpStatus.valueOf(404));
        }else{
            //verificam daca utilizatorul care sterge prietenul este cel logat
            if(prietenie1.getUtilizator1() == user_curent) {
                //cand stergem un prieten, stergem si relatia in sens invers
                Prietenie prietenie2 = getPrietenieByUsers(id, user_curent.getIdUtilizator());
                deletePrietenie(prietenie1);
                deletePrietenie(prietenie2);
                return new ResponseEntity<>(HttpStatus.valueOf(200));

            }else{
                return new ResponseEntity<>("Nu puteti sterge acest prieten.",HttpStatus.valueOf(400));

            }
        }
    }

    public ResponseEntity<String> rejectFriendRequest(Utilizator user_curent, Long id){
        Response response = new Response();
        Prietenie prietenie1 = getPrietenieByUsers(id, user_curent.getIdUtilizator());
        //verificam daca exista prietenia a carui status dorim sa-l schimbam; daca nu exista -> eroare
        if(prietenie1 == null){
            return new ResponseEntity<>("Cererea de prietenie nu exista",HttpStatus.valueOf(404));

        }else{
            //verificam daca utilizatorul care accepta cererea este cel logat
            if(prietenie1.getUtilizator2() == user_curent) {
                //cand respingem cererea, stergem din baza de date prietenia; nu modificam statusul
                //la respins, ca sa poata fi trimisa ulterior alta cerere
                deletePrietenie(prietenie1);
                return new ResponseEntity<>(HttpStatus.valueOf(200));
            }else{
                return new ResponseEntity<>("Nu puteti respinge aceasta cerere",HttpStatus.valueOf(400));

            }
        }
    }


}
