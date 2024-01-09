package com.example.moviematchbackend.services.film_service;

import com.example.moviematchbackend.models.entity.Film;
import com.example.moviematchbackend.models.entity.Utilizator;
import com.example.moviematchbackend.repositories.FilmRepository;
import com.example.moviematchbackend.services.utilizator_service.UtilizatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;


//acea clasa care imi face legatura dintre frontend si backend
@Service
public class FilmService implements FilmServiceInterface {
    //acest obiect este folosit pentru a apela metodele din clasa FilmRepository
    private FilmRepository filmRepository;

    private List<Film> myFavouriteListOfFilms;

    //acest constructor este folosit pentru a crea un obiect de tip FilmService
    @Autowired
    public FilmService(FilmRepository filmRepository, List<Film> myFavouriteListOfFilms) {
        this.filmRepository = filmRepository;
        this.myFavouriteListOfFilms = myFavouriteListOfFilms;
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

    @Override
    public void addMovieToYourOwnList(Film film) {
        this.myFavouriteListOfFilms.add(film);
    }

    @Override
    public List<Film> getFilmsFromMyFavouriteList() {
        return this.myFavouriteListOfFilms.stream().toList();
    }

    @Override
    public void deleteFilmFromFavouriteList(Long id) {
        for (Film film1 : this.getFilmsFromMyFavouriteList()) {
            if (film1.getIdFilm() == id) {
                this.myFavouriteListOfFilms.remove(film1);
            }
        }
    }


    public List<Film> getFilmeByGen(String gen) {
        return this.filmRepository.getFilmeByGen(gen);
    }

    public List<Film> getFilmeByLocatieFilmare(String locatieFilmare) {
        return this.filmRepository.getFilmeByLocatieFilmare(locatieFilmare);
    }




}
