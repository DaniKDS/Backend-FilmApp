package com.example.moviematchbackend.controller;

import com.example.moviematchbackend.models.mapper.Film;
import com.example.moviematchbackend.repositories.FilmRepository;
import com.example.moviematchbackend.services.film_service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController {
    private FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/api/filme")
    public List<Film> getFilme() {
        return this.filmService.getAllFilme();
    }
    //acest endpoint imi returneaza toate filmele din baza de date in format json

    @GetMapping("/api/filme/id/{id}")
    public Film getFilmById(@PathVariable Long id) {
        return filmService.getFilmByIdFilm(id);
    }

    @GetMapping("/api/filme/titlu/{titlu}")
    public Film getFilmByTitlu(@PathVariable String titlu) {
        return filmService.getFilmByTitluFilm(titlu);
    }

    @PostMapping("/api/filme")
    public Film addFilm(@RequestBody Film film) {
        return this.filmService.saveFilm(film);
    }

    @DeleteMapping("/api1/filme/{id}")
    public void deleteFilm(@PathVariable Long id) {
        this.filmService.deleteFilm(this.filmService.getFilmByIdFilm(id));
    }

}