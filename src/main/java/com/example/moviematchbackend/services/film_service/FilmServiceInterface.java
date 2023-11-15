package com.example.moviematchbackend.services.film_service;
import com.example.moviematchbackend.models.mapper.Film;

import java.util.List;

public interface FilmServiceInterface {

    List<Film> getAllFilme();
    //Aceasta functie returneaza toate filmele din baza de date

    Film saveFilm(Film film);
    //Aceasta functie salveaza un film in baza de date

    void deleteFilm(Film film);
    //Aceasta functie sterge un film din baza de date

    Film getFilmByIdFilm(Long id);

    Film getFilmByTitluFilm(String titlu);
    //Aceasta functie returneaza un film din baza de date dupa id-ul sau

}
