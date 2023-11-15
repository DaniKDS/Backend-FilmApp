package com.example.moviematchbackend.controller;

import com.example.moviematchbackend.models.mapper.Film;
import com.example.moviematchbackend.repositories.FilmRepository;
import com.example.moviematchbackend.services.film_service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/api/filme/{id}")
    public Film getFilmById(Long id) {
        return this.filmService.getFilmByIdFilm(id);
    }

    @GetMapping("/api/filme/{titlu}")
    public Film getFilmByTitlu(String titlu) {
        return this.filmService.getFilmByTitluFilm(titlu);
    }

    @PostMapping("/api/filme")
    public Film addFilm(Film film) {
        return this.filmService.saveFilm(film);
    }

    @DeleteMapping("/api/filme/{id}")
    public void deleteFilm(Long id) {
        this.filmService.deleteFilm(this.filmService.getFilmByIdFilm(id));
    }

}
