package com.example.moviematchbackend.services.prietenie_service;

import com.example.moviematchbackend.models.mapper.Prietenie;

import java.util.List;

public interface PrietenieServiceInterface {

    List<Prietenie> getAllPrietenii();
    //aceasta metoda returneaza toate prieteniile din baza de date

    Prietenie getPrietenieById(Long id);
    //aceasta metoda returneaza prietenia cu id-ul id (daca exista)

    Prietenie savePrietenie(Prietenie prietenie);
    //aceasta metoda salveaza o prietenie in baza de date

    void deletePrietenie(Prietenie prietenie);
    //aceasta metoda sterge o prietenie din baza de date

}
