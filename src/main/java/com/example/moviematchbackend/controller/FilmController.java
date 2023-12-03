package com.example.moviematchbackend.controller;

import com.example.moviematchbackend.models.dto.FilmDto;
import com.example.moviematchbackend.models.entity.Film;
import com.example.moviematchbackend.models.mapper.FilmMapper;
import com.example.moviematchbackend.services.film_service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController {

    private final FilmService filmService;
    private final FilmMapper filmMapper;

    @Autowired
    public FilmController(FilmService filmService, FilmMapper filmMapper) {
        this.filmService = filmService;
        this.filmMapper = filmMapper;
    }

    @GetMapping("/api/filme")
    public List<FilmDto> getFilme() {
        List<Film> filme = this.filmService.getAllFilme();
        return filmMapper.filmeToFilmDtoList(filme);
    }

    @GetMapping("/api/filme/id/{id}")
    public FilmDto getFilmById(@PathVariable Long id) {
        Film film = filmService.getFilmByIdFilm(id);
        return filmMapper.filmToFilmDto(film);
    }

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

    @DeleteMapping("/api1/filme/{id}")
    public void deleteFilm(@PathVariable Long id) {
        this.filmService.deleteFilm(this.filmService.getFilmByIdFilm(id));
    }
}