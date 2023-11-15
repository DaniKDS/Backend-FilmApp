package com.example.moviematchbackend.services.pereche_service;

import com.example.moviematchbackend.models.mapper.Pereche;

import java.util.List;

public interface PerecheServiceInterface {

    Pereche getPerecheById(Long idPereche);
    //aceasta metoda va fi folosita pentru a returna o pereche dupa id (daca exista)

    List<Pereche> getAllPereche();
    //aceasta metoda va fi folosita pentru a returna toate perechile din baza de date
    Pereche savePereche(Pereche pereche);
    //aceasta metoda va fi folosita pentru a salva o pereche in baza de date

    void deletePereche(Pereche pereche);
    //aceasta metoda va fi folosita pentru a sterge o pereche din baza de date

}
