package com.example.moviematchbackend.services.utilizator_service;

import com.example.moviematchbackend.models.mapper.Utilizator;

import java.util.List;
//aceasta interfata este folosita pentru a apela metodele din clasa UtilizatorService

public interface UtilizatorServiceInterface {

    List<Utilizator> getAllUtilizatori();
    // aceasta metoda va fi folosita pentru a returna toti utilizatorii din baza de date

    Utilizator getUtilizatorById(Long idUtilizator);
    // aceasta metoda va fi folosita pentru a returna un utilizator dupa id-ul sau (daca exista)

    Utilizator getUtilizatorByUsername(String usernameUtilizator);
    // aceasta metoda va fi folosita pentru a returna un utilizator dupa username-ul sau (daca exista)

    Utilizator saveUtilizator(Utilizator utilizator);
    // aceasta metoda va fi folosita pentru a salva un utilizator in baza de date

    void deleteUtilizator(Utilizator utilizator);
    // aceasta metoda va fi folosita pentru a sterge un utilizator din baza de date



}
