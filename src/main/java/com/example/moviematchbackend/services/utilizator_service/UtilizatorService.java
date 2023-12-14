package com.example.moviematchbackend.services.utilizator_service;

import com.example.moviematchbackend.models.entity.Utilizator;
import com.example.moviematchbackend.repositories.UtilizatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//acea clasa care imi face legatura dintre frontend si backend
@Service
public class UtilizatorService implements UtilizatorServiceInterface{

    @Autowired
    //acest obiect este folosit pentru a apela metodele din clasa UtilizatorRepository
    private UtilizatorRepository utilizatorRepository;
    //acest constructor este folosit pentru a crea un obiect de tip UtilizatorService
    public UtilizatorService(UtilizatorRepository utilizatorRepository) {
        this.utilizatorRepository = utilizatorRepository;
    }
    //acesta metoda imi returneaza toate utilizatorii din baza de date in format json
    @Override
    public List<Utilizator> getAllUtilizatori() {
        List<Utilizator> listOfUtilizatori = new ArrayList<>();
        this.utilizatorRepository.findAll().forEach(utilizator -> listOfUtilizatori.add(utilizator));
        return listOfUtilizatori;
    }
    //acesta metoda imi returneaza toate utilizatorii din baza de date in format json

    @Override
    public Utilizator getUtilizatorById(Long idUtilizator) {
        return this.utilizatorRepository.getUtilizatorByIdUtilizator(idUtilizator);
    }
    //acesta metoda imi returneaza un utilizator dupa id in format json

    @Override
    public Utilizator getUtilizatorByEmail(String email) {
        return this.utilizatorRepository.getUtilizatorByEmailUtilizator(email);
    }
    @Override
    public Utilizator getUtilizatorByUsername(String usernameUtilizator) {
        return this.utilizatorRepository.getUtilizatorByUsernameUtilizator(usernameUtilizator);
    }
    //acesta metoda imi returneaza un utilizator dupa username in format json

    @Override
    public Utilizator saveUtilizator(Utilizator utilizator) {
        return this.utilizatorRepository.save(utilizator);
    }

    //acesta metoda imi adauga un utilizator in baza de date



    @Override
    public void deleteUtilizator(Utilizator utilizator) {
        this.utilizatorRepository.delete(utilizator);
    }

    //acesta metoda imi sterge un utilizator din baza de date
}
