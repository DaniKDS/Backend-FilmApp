package com.example.moviematchbackend.repositories;

import org.springframework.data.repository.CrudRepository;

public interface PrietenieRepository<Prietenie> extends CrudRepository<Prietenie, Long> {

    Prietenie getPrietenieByPrietenieId(Long prietenieId);
    //aceasta functie returneaza prietenia cu id-ul prietenieId
    Prietenie getPrietenieByUserId1AndUserId2(Long userId1, Long userId2);
    //aceasta functie returneaza prietenia dintre userId1 si userId2, indiferent de ordinea in care sunt introdusi parametrii
    Prietenie getPrietenieByUserId2AndUserId1(Long userId2, Long userId1);
    //aceasta functie returneaza prietenia dintre userId1 si userId2, indiferent de ordinea in care sunt introdusi parametrii
    Iterable<Prietenie> getPrietenieByUserId1(Long userId1);
    //aceasta functie returneaza toate prieteniile in care userId1 este userul care a trimis cererea de prietenie si userId2 este userul care a primit cererea de prietenie

    Iterable<Prietenie> getPrietenieByUserId2(Long userId2);
    //aceasta functie

}
