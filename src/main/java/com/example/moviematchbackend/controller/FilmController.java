package com.example.moviematchbackend.controller;

import com.example.moviematchbackend.models.entity.Film;
import com.example.moviematchbackend.models.entity.Prietenie;
import com.example.moviematchbackend.models.entity.StatusCerere;
import com.example.moviematchbackend.models.entity.Utilizator;
import com.example.moviematchbackend.services.film_service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
//acea clasa care imi face legatura dintre frontend si backend
@RestController
public class FilmController {
    private FilmService filmService;
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

    @GetMapping("/api/filme/id/{id}")
    public Film getFilmById(@PathVariable Long id) {
        return filmService.getFilmByIdFilm(id);
    }
    //acest endpoint imi returneaza un film dupa id in format json
    @GetMapping("/api/filme/titlu/{titlu}")
    public Film getFilmByTitlu(@PathVariable String titlu) {
        return filmService.getFilmByTitlu(titlu);
    }
    //acest endpoint imi returneaza un film dupa id in format json
    @PostMapping("/api/filme")
    public Film addFilm(@RequestBody Film film) {
        return this.filmService.saveFilm(film);
    }
    //acest endpoint imi adauga un film in baza de date
    @DeleteMapping("/api1/filme/{id}")
    public void deleteFilm(@PathVariable Long id) {
        this.filmService.deleteFilm(this.filmService.getFilmByIdFilm(id));
    }
    //acest endpoint imi sterge un film din baza de date

}