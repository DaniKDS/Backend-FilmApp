package com.example.moviematchbackend.services.utilizator_service;

import com.example.moviematchbackend.models.mapper.Utilizator;
import com.example.moviematchbackend.repositories.UtilizatorRepository;

import java.util.ArrayList;
import java.util.List;

public class UtilizatorService implements UtilizatorServiceInterface{

    private UtilizatorRepository utilizatorRepository;

    @Override
    public List<Utilizator> getAllUtilizatori() {
        List<Utilizator> utilizatori = new ArrayList<>();
        this.utilizatorRepository.findAll().forEach(utilizator -> utilizatori.add(utilizator));
        return utilizatori;
    }

    @Override
    public Utilizator getUtilizatorById(Long utilizatorId) {
        return this.utilizatorRepository.getUtilizatorByUtilizatorId(utilizatorId);
    }

    @Override
    public Utilizator getUtilizatorByUsername(String username) {
        return this.utilizatorRepository.getUtilizatorByUsername(username);
    }

    @Override
    public Utilizator saveUtilizator(Utilizator utilizator) {
        return this.utilizatorRepository.save(utilizator);
    }

    @Override
    public void deleteUtilizator(Utilizator utilizator) {
        this.utilizatorRepository.delete(utilizator);
    }
}
