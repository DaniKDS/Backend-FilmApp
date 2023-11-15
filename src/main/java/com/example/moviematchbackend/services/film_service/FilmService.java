package com.example.moviematchbackend.services.film_service;

import com.example.moviematchbackend.models.mapper.Film;
import com.example.moviematchbackend.repositories.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService implements FilmServiceInterface{

    private FilmRepository filmRepository;

    @Override
    public List<Film> getAllFilme() {
        List<Film> listOfFilms = new ArrayList<>();
        this.filmRepository.findAll().forEach(film -> listOfFilms.add(film));
        return listOfFilms;

    }
    @Override
    public Film saveFilm(Film film) {
        return this.filmRepository.save(film);

    }

    @Override
    public void deleteFilm(Film film) {
        this.filmRepository.delete(film);

    }

    @Override
    public Film getFilmByIdFilm(Long id) {
        return this.filmRepository.getFilmByIdFilm(id);
    }

    @Override
    public Film getFilmByTitluFilm(String titlu) {
        return this.filmRepository.getFilmByTitluFilm(titlu);
    }
}
