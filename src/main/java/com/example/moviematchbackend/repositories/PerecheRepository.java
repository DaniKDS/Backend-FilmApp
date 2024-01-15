package com.example.moviematchbackend.repositories;

import com.example.moviematchbackend.models.entity.Pereche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
// În interfața PerecheRepository
public interface PerecheRepository extends JpaRepository<Pereche, Long> {
    Pereche getPerecheByIdPereche(Long idPereche);
    //Aceasta functie returneaza perechea cu id-ul idPereche

}
