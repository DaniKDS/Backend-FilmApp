package com.example.moviematchbackend.controller;


import com.example.moviematchbackend.models.entity.*;
import com.example.moviematchbackend.services.film_service.FilmService;
import com.example.moviematchbackend.services.pereche_service.PerecheService;
import com.example.moviematchbackend.services.utilizator_service.UtilizatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//acea clasa care imi face legatura dintre fron
@RestController
public class PerecheController {
    @Autowired
    private PerecheService perecheService;
    @Autowired
    private UtilizatorService utilizatorService;
    @Autowired
    private FilmService filmService;

    @Autowired
    public PerecheController(PerecheService perecheService, UtilizatorService utilizatorService) {
        this.perecheService = perecheService;
        this.utilizatorService = utilizatorService;
    }
    //acest constructor este folosit pentru a crea un obiect de tip PerecheController
    @GetMapping("/api/perechi")
    public List<Pereche> getPerechi() {
        return this.perecheService.getAllPereche();

    }
    //acest endpoint imi returneaza toate perechile din baza de date in format json

    @GetMapping("/api/perechi/{id}")
    public Pereche getPerecheById(@PathVariable Long id) {
        return perecheService.getPerecheById(id);
    }
    //acest endpoint imi returneaza o pereche dupa id in format json
    @GetMapping("/api/filme_de_vazut")
    public List<Film> getMoviesToSee(Authentication authentication){
        String user_email = ((DefaultOidcUser) authentication.getPrincipal()).getEmail();
        Utilizator user_curent = utilizatorService.getUtilizatorByEmail(user_email);
        return perecheService.getMoviesToSee(user_curent);
    }
    @GetMapping("/api/filme_vazute")
    public List<Film> getSeenMovies(Authentication authentication){
        String user_email = ((DefaultOidcUser) authentication.getPrincipal()).getEmail();
        Utilizator user_curent = utilizatorService.getUtilizatorByEmail(user_email);
        return perecheService.getSeenMovies(user_curent);
    }
    @GetMapping("/api/filme_comune/{id}")
    public List<Film> getMoviesWithFriend(Authentication authentication, @PathVariable Long id){
        String user_email = ((DefaultOidcUser) authentication.getPrincipal()).getEmail();
        Utilizator user_curent = utilizatorService.getUtilizatorByEmail(user_email);
        return perecheService.getMoviesWithFriend(user_curent, utilizatorService.getUtilizatorById(id));
    }

    @GetMapping("/api/filme_nefavorite_gen/{gen}")
    public List<Film> getMoviesByGenreNotInFavouriteList(Authentication authentication, @PathVariable String gen){
        String user_email = ((DefaultOidcUser) authentication.getPrincipal()).getEmail();
        Utilizator user_curent = utilizatorService.getUtilizatorByEmail(user_email);
        List<Film> movies = filmService.getFilmeByGen(gen);
        List<Film> moviesToSee = perecheService.getMoviesToSee(user_curent);
        List<Film> seenMovies = perecheService.getSeenMovies(user_curent);
        movies.retainAll(moviesToSee);
        movies.retainAll(seenMovies);
        return movies;
    }

    @GetMapping("/api/filme_nefavorite_tara/{locatie}")
    public List<Film> getMoviesByCountryNotInFavouriteList(Authentication authentication, @PathVariable String locatie){
        String user_email = ((DefaultOidcUser) authentication.getPrincipal()).getEmail();
        Utilizator user_curent = utilizatorService.getUtilizatorByEmail(user_email);
        List<Film> movies = filmService.getFilmeByLocatieFilmare(locatie);
        List<Film> moviesToSee = perecheService.getMoviesToSee(user_curent);
        List<Film> seenMovies = perecheService.getSeenMovies(user_curent);
        movies.retainAll(moviesToSee);
        movies.retainAll(seenMovies);
        return movies;
    }

}