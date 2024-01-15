package com.example.moviematchbackend.repositories;

import com.example.moviematchbackend.models.entity.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {
    Film getFilmByIdFilm(Long idFilm);
    //Aceasta functie returneaza filmul cu id-ul idFilm
    Film getFilmByTitlu(String titlu);
    //Aceasta functie returneaza filmul cu titlul titlu
    List<Film> getFilmeByGen(String gen);
    //Aceasta functie returneaza toate filmele cu genul gen
    List<Film> getFilmByLocatieFilmare(String locatieFilmare);
    //Aceasta functie returneaza filmul cu id-ul idFilm

}
