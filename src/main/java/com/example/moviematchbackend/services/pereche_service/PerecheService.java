package com.example.moviematchbackend.services.pereche_service;

import com.example.moviematchbackend.models.mapper.Film;
import com.example.moviematchbackend.models.mapper.Pereche;
import com.example.moviematchbackend.models.mapper.Utilizator;
import com.example.moviematchbackend.repositories.PerecheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class PerecheService implements PerecheServiceInterface{

    //@Autowired
    private PerecheRepository perecheRepository;

    public PerecheService(PerecheRepository perecheRepository) {
        this.perecheRepository = perecheRepository;
    }


    @Override
    public Pereche getPerecheById(Long id) {
        return this.perecheRepository.getPerecheByIdPereche(id);
    }

    @Override
    public List<Pereche> getAllPereche() {
        List<Pereche> listOfPereche = new ArrayList<>();
        this.perecheRepository.findAll().forEach(pereche -> listOfPereche.add(pereche));
        return listOfPereche;

    }

    @Override
    public void deletePereche(Pereche pereche) {
        this.perecheRepository.delete(pereche);
    }

    @Override
    public void savePereche(Utilizator utilizator, Film film) {
        Pereche pereche = new Pereche(utilizator, film);
        this.perecheRepository.save(pereche);
    }

}