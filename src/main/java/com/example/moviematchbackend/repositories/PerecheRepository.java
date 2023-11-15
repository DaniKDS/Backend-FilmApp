package com.example.moviematchbackend.repositories;

import com.example.moviematchbackend.models.mapper.Pereche;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PerecheRepository extends CrudRepository<Pereche, Long> {

    Pereche getPerecheByIdPereche(Long id);

    Object getPerecheByIdUtilizator(Long idUtilizator);
    //Aceasta functie returneaza perechea cu id-ul idPereche

}
