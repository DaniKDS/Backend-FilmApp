package com.example.moviematchbackend.controller;

import com.example.moviematchbackend.models.dto.FilmDto;
import com.example.moviematchbackend.models.entity.Film;
import com.example.moviematchbackend.models.entity.Prietenie;
import com.example.moviematchbackend.models.entity.StatusCerere;
import com.example.moviematchbackend.models.entity.Utilizator;
import com.example.moviematchbackend.models.mapper.FilmMapper;
import com.example.moviematchbackend.services.film_service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.metal.MetalIconFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//acea clasa care imi face legatura dintre frontend si backend


@RestController
public class FilmController {


    private final FilmService filmService;
    private final FilmMapper filmMapper;

    @Autowired
    public FilmController(FilmService filmService, FilmMapper filmMapper) {
        this.filmService = filmService;
        this.filmMapper = filmMapper;
    }
    //acest constructor este folosit pentru a crea un obiect de tip FilmController

    @GetMapping("/api/filme")
    public List<FilmDto> getFilme() {
        List<Film> filme = this.filmService.getAllFilme();
        return filmMapper.filmeToFilmDtoList(filme);
    }
    //acest endpoint imi returneaza toate filmele din baza de date in format json
    public List<Film> getFilme1() {
        return this.filmService.getAllFilme();
    }
    @GetMapping("/api/filme/id/{id}")
    public FilmDto getFilmById(@PathVariable Long id) {
        Film film = filmService.getFilmByIdFilm(id);
        return filmMapper.filmToFilmDto(film);
    }
    //acest endpoint imi returneaza un film dupa id in format json
    @GetMapping("/api/filme/titlu/{titlu}")
    public FilmDto getFilmByTitlu(@PathVariable String titlu) {
        Film film = filmService.getFilmByTitlu(titlu);
        return filmMapper.filmToFilmDto(film);
    }

    @GetMapping("/api/filme/gen/{gen}")
    public List<FilmDto> getFilmeByGen(@PathVariable String gen) {
        List<Film> filme = filmService.getFilmeByGen(gen);
        return filmMapper.filmeToFilmDtoList(filme);
    }

    //acest endpoint imi returneaza un film dupa id in format json

    @GetMapping("/api/filme/locatie/{locatieFilmare}")
    public List<FilmDto> getFilmeByLocatieFilmare(@PathVariable String locatieFilmare) {
        List<Film> filme = filmService.getFilmeByLocatieFilmare(locatieFilmare);
        return filmMapper.filmeToFilmDtoList(filme);
    }

    @PostMapping("/api/filme")
    public FilmDto addFilm(@RequestBody FilmDto filmDto) {
        Film film = filmMapper.filmDtoToFilm(filmDto);
        Film savedFilm = this.filmService.saveFilm(film);
        return filmMapper.filmToFilmDto(savedFilm);
    }

    //acest endpoint imi adauga un film in baza de date
    @DeleteMapping("/api/filme/{id}")
    public void deleteFilm(@PathVariable Long id) {
        this.filmService.deleteFilm(this.filmService.getFilmByIdFilm(id));
    }
    //acest endpoint imi sterge un film din baza de date
    @PostMapping("/api/listafilme")
    public void addMovieToYourOwnList(@RequestBody Film film) {
        this.filmService.addMovieToYourOwnList(film);
    }

    @DeleteMapping("/api/filmelista/{id}")
    public void deleteFilmFromFavouriteList(@PathVariable Long id) {
        this.filmService.deleteFilmFromFavouriteList(id);
    }

    @GetMapping("/api/filmelista")
    public List<Film> getFilmsFromFavouriteList() {
        return this.filmService.getFilmsFromMyFavouriteList();
    }

    @GetMapping("/api/filter_movie/{searchText}")
    public List<FilmDto> handleFilter(@PathVariable String searchText) {
        List<FilmDto> filme = getFilme();
        List<FilmDto> filme1 = getFilme();
        Set<String> lowerCaseTitles = filme1.stream()
                .map(film -> film.getTitlu().toLowerCase())
                .collect(Collectors.toSet());

        // Filter filme based on lowercase titles present in filme1
        Predicate<FilmDto> p1 = film -> lowerCaseTitles.contains(film.getTitlu().toLowerCase()) && film.getTitlu().toLowerCase().contains(searchText.toLowerCase());
        filme = filme.stream()
                .filter(p1)
                .collect(Collectors.toList());

        return filme;
    }
    @GetMapping("/api/filter_movie/")
    public List<FilmDto> emptyfilter(){
        return getFilme();
    }
}