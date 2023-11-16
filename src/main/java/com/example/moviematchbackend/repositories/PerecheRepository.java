package com.example.moviematchbackend.repositories;

import com.example.moviematchbackend.models.mapper.Film;
import com.example.moviematchbackend.models.mapper.Pereche;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
// În interfața PerecheRepository
public interface PerecheRepository extends JpaRepository<Pereche, Long> {
//    Optional<Pereche> findFirstPerecheByUtilizatorId(Long idUtilizator);
    //acea metoda care imi returneaza o pereche dupa idUtilizator
    Pereche getPerecheByIdPereche(Long idPereche);
    //acea metoda care imi returneaza o pereche dupa idPereche

}
