package com.example.moviematchbackend.repositories;

import com.example.moviematchbackend.models.entity.Utilizator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilizatorRepository extends CrudRepository<Utilizator, Long> {
    Utilizator getUtilizatorByIdUtilizator(Long idUtilizator);
    //Aceasta functie returneaza utilizatorul cu id-ul idUtilizator
    Utilizator getUtilizatorByUsernameUtilizator(String numeUtilizator);
    //Aceasta functie returneaza utilizatorul cu username-ul numeUtilizator

    Utilizator getUtilizatorByEmailUtilizator(String email);
    //Aceasta functie returneaza utilizatorul cu username-ul numeUtilizator


}
