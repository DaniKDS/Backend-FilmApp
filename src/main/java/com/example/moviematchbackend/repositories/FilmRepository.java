package com.example.moviematchbackend.repositories;

import com.example.moviematchbackend.models.mapper.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Long> {
    Film getFilmByFilmId(Long filmId);
    //Aceasta functie returneaza filmul cu id-ul filmId (daca exista)
    Film getFilmByTitle(String title);
    //Aceasta functie returneaza filmul cu titlul title (daca exista)

}
