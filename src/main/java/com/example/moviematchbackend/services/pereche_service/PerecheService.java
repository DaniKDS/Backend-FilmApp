package com.example.moviematchbackend.services.pereche_service;

import com.example.moviematchbackend.models.entity.Film;
import com.example.moviematchbackend.models.entity.Pereche;
import com.example.moviematchbackend.models.entity.Utilizator;
import com.example.moviematchbackend.repositories.PerecheRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//acea clasa care imi face legatura dintre frontend si backend
@Service

public class PerecheService implements PerecheServiceInterface{

    //@Autowired
    private PerecheRepository perecheRepository;
    //acest constructor este folosit pentru a crea un obiect de tip PerecheService
    public PerecheService(PerecheRepository perecheRepository) {
        this.perecheRepository = perecheRepository;
    }

    //acesta metoda imi returneaza o pereche dupa id in format json
    @Override
    public Pereche getPerecheById(Long id) {
        return this.perecheRepository.getPerecheByIdPereche(id);
    }
    //acesta metoda imi returneaza o pereche dupa id in format json
    @Override
    public List<Pereche> getAllPereche() {
        List<Pereche> listOfPereche = new ArrayList<>();
        this.perecheRepository.findAll().forEach(pereche -> listOfPereche.add(pereche));
        return listOfPereche;

    }
    //acesta metoda imi returneaza toate perechile din baza de date in format json

    @Override
    public void deletePereche(Pereche pereche) {
        this.perecheRepository.delete(pereche);
    }
    //acesta metoda imi sterge o pereche din baza de date
    @Override
    public void savePereche(Utilizator utilizator, Film film) {
        Pereche pereche = new Pereche(utilizator, film);
        this.perecheRepository.save(pereche);
    }

}