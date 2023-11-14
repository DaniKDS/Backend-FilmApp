package com.example.moviematchbackend.repositories;

import com.example.moviematchbackend.models.mapper.Pereche;
import org.springframework.data.repository.CrudRepository;

public interface PerecheRepository extends CrudRepository<Pereche, Long> {
    Pereche getPerecheByPerecheId(Long perecheId);
    //Aceasta functie returneaza perechea cu id-ul perecheId (daca exista)
    Pereche getPerecheByUserId1AndUserId2(Long userId1, Long userId2);
    //Aceasta functie returneaza perechea dintre userId1 si userId2, indiferent de ordinea in care sunt introdusi parametrii
    Pereche getPerecheByUserId2AndUserId1(Long userId2, Long userId1);
    //Aceasta functie returneaza perechea dintre userId1 si userId2, indiferent de ordinea in care sunt introdusi parametrii
    Iterable<Pereche> getPerecheByUserId1(Long userId1);
    //Aceasta functie returneaza toate perechile in care userId1 este userul care a trimis cererea de prietenie si userId2 este userul care a primit cererea de prietenie

}
