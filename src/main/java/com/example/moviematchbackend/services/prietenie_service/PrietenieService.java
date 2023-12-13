package com.example.moviematchbackend.services.prietenie_service;

import com.example.moviematchbackend.models.entity.Prietenie;
import com.example.moviematchbackend.models.entity.StatusCerere;
import com.example.moviematchbackend.models.entity.Utilizator;
import com.example.moviematchbackend.repositories.PrietenieRepository;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
//acea clasa care imi face legatura dintre frontend si backend

@Service
public class PrietenieService implements PrietenieServiceInterface {

    @Autowired
    //acest obiect este folosit pentru a apela metodele din clasa PrietenieRepository
    private PrietenieRepository prietenieRepository;
    //acest constructor este folosit pentru a crea un obiect de tip PrietenieService
    public PrietenieService(PrietenieRepository prietenieRepository) {
        this.prietenieRepository = prietenieRepository;
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
            if(Objects.equals(prietenie.getUtilizator2().getIdUtilizator(), idUtil1) && Objects.equals(prietenie.getUtilizator1().getIdUtilizator(), idUtil2)){
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

}
