package com.example.moviematchbackend.repositories;

import com.example.moviematchbackend.models.mapper.Utilizator;
import org.springframework.data.repository.CrudRepository;

public interface UtilizatorRepository extends CrudRepository<Utilizator, Long> {
    Utilizator getUtilizatorByUtilizatorId(Long utilizatorId);
    //Aceasta functie returneaza utilizatorul cu id-ul utilizatorId (daca exista)
    Utilizator getUtilizatorByUsername(String username);
    //Aceasta functie returneaza utilizatorul cu username-ul username (daca exista)


}
