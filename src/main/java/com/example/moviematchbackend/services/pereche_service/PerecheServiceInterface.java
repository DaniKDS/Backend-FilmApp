package com.example.moviematchbackend.services.pereche_service;

import com.example.moviematchbackend.models.mapper.Film;
import com.example.moviematchbackend.models.mapper.Pereche;
import com.example.moviematchbackend.models.mapper.Utilizator;

import java.util.List;
//aceasta interfata este folosita pentru a apela metodele din clasa PerecheService
public interface PerecheServiceInterface {

    Pereche getPerecheById(Long idPereche);
    //aceasta metoda va fi folosita pentru a returna o pereche dupa id (daca exista)

    List<Pereche> getAllPereche();
    //aceasta metoda va fi folosita pentru a returna toate perechile din baza de date

    void deletePereche(Pereche pereche);

    void savePereche(Utilizator utilizator, Film film);
    //aceasta metoda va fi folosita pentru a sterge o pereche din baza de date

}