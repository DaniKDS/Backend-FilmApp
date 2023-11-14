package com.example.moviematchbackend.services.film_service;
import com.example.moviematchbackend.models.mapper.Film;

import java.util.List;

public interface FilmServiceInterface {
    Film getFilmById(Long filmId);
    //Aceasta functie returneaza filmul cu id-ul filmId (daca exista)
    Film getFilmByTitle(String title);
    //Aceasta functie returneaza filmul cu titlul title (daca exista)

    List<Film> getAllFilms();
    //Aceasta functie returneaza toate filmele din baza de date

    Film saveFilm(Film film);
    //Aceasta functie salveaza un film in baza de date

    void deleteFilm(Film film);
    //Aceasta functie sterge un film din baza de date

}
