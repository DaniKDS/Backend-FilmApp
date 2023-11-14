package com.example.moviematchbackend.services.film_service;

import com.example.moviematchbackend.models.mapper.Film;
import com.example.moviematchbackend.repositories.FilmRepository;

import java.util.List;

public class FilmService implements FilmServiceInterface{

    private FilmRepository filmRepository;

    @Override
    public Film getFilmById(Long filmId) {
        return null;
    }

    @Override
    public Film getFilmByTitle(String title) {
        return null;
    }

    @Override
    public List<Film> getAllFilms() {
        return null;
    }

    @Override
    public Film saveFilm(Film film) {
        return null;
    }

    @Override
    public void deleteFilm(Film film) {

    }
}
