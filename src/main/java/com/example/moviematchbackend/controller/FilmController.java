package com.example.moviematchbackend.controller;

import com.example.moviematchbackend.models.mapper.Film;
import com.example.moviematchbackend.repositories.FilmRepository;
import com.example.moviematchbackend.services.film_service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//acea clasa care imi face legatura dintre frontend si backend
@RestController
public class FilmController {
    private FilmService filmService;
    //acest obiect este folosit pentru a apela metodele din clasa FilmService
    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }
    //acest constructor este folosit pentru a crea un obiect de tip FilmController
    @GetMapping("/api/filme")
    public List<Film> getFilme() {
        return this.filmService.getAllFilme();
    }
    //acest endpoint imi returneaza toate filmele din baza de date in format json
    //acest endpoint este de tip get
    @GetMapping("/api/filme/id/{id}")
    public Film getFilmById(@PathVariable Long id) {
        return filmService.getFilmByIdFilm(id);
    }
    //acest endpoint imi returneaza un film dupa id in format json
    @GetMapping("/api/filme/titlu/{titlu}")
    public Film getFilmByTitlu(@PathVariable String titlu) {
        return filmService.getFilmByTitluFilm(titlu);
    }
    //acest endpoint imi returneaza un film dupa titlu in format json
    @PostMapping("/api/filme")
    public Film addFilm(@RequestBody Film film) {
        return this.filmService.saveFilm(film);
    }
    //acest endpoint imi adauga un film in baza de date

    @DeleteMapping("/api1/filme/{id}")
    public void deleteFilm(@PathVariable Long id) {
        this.filmService.deleteFilm(this.filmService.getFilmByIdFilm(id));
    }


}