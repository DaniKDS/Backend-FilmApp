package com.example.moviematchbackend.repositories;

import com.example.moviematchbackend.models.entity.Utilizator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilizatorRepository extends CrudRepository<Utilizator, Long> {
    Utilizator getUtilizatorByIdUtilizator(Long idUtilizator);
    //Aceasta functie returneaza utilizatorul cu id-ul idUtilizator (daca exista)
    Utilizator getUtilizatorByUsernameUtilizator(String numeUtilizator);
    //Aceasta functie returneaza utilizatorul cu username-ul numeUtilizator (daca exista)

    Utilizator getUtilizatorByEmailUtilizator(String email);
    //Aceasta functie returneaza utilizatorul cu username-ul numeUtilizator (daca exista)


}
