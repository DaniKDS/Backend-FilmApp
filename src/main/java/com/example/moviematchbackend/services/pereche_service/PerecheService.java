package com.example.moviematchbackend.services.pereche_service;

import com.example.moviematchbackend.models.mapper.Pereche;
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
    public Pereche savePereche(Pereche pereche) {
        return this.perecheRepository.save(pereche);
    }

    @Override
    public void deletePereche(Pereche pereche) {
        this.perecheRepository.delete(pereche);
    }

//    public Object getPerecheByIdUtilizator(Long idUtilizator) {
//        return this.perecheRepository.getPerecheByIdUtilizator(idUtilizator);
//    }
}
