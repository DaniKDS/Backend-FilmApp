package com.example.moviematchbackend.services.film_service;

import com.example.moviematchbackend.models.entity.Film;
import com.example.moviematchbackend.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//acea clasa care imi face legatura dintre frontend si backend
@Service
public class FilmService implements FilmServiceInterface{
    //acest obiect este folosit pentru a apela metodele din clasa FilmRepository
    private FilmRepository filmRepository;
    //acest constructor este folosit pentru a crea un obiect de tip FilmService
    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
    //aceasta metoda imi returneaza toate filmele din baza de date in format json
    @Override
    public List<Film> getAllFilme() {
        List<Film> listOfFilms = new ArrayList<>();
        this.filmRepository.findAll().forEach(film -> listOfFilms.add(film));
        return listOfFilms;

    }
    //acesta metoda imi returneaza toate filmele din baza de date
    @Override
    public Film saveFilm(Film film) {
        return this.filmRepository.save(film);

    }
    //acesta metoda imi adauga un film in baza de date
    @Override
    public void deleteFilm(Film film) {
        this.filmRepository.delete(film);

    }
    //acesta metoda imi sterge un film din baza de date
    @Override
    public Film getFilmByIdFilm(Long id) {
        return this.filmRepository.getFilmByIdFilm(id);
    }

    @Override
    public Film getFilmByTitlu(String titlu) {
        return this.filmRepository.getFilmByTitlu(titlu);
    }

    public List<Film> getFilmeByGen(String gen) {
        return this.filmRepository.getFilmeByGen(gen);
    }

    public List<Film> getFilmeByLocatieFilmare(String locatieFilmare) {
        return this.filmRepository.getFilmeByLocatieFilmare(locatieFilmare);
    }
}
