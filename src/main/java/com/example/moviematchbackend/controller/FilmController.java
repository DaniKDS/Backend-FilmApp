package com.example.moviematchbackend.controller;

import com.example.moviematchbackend.models.dto.FilmDto;
import com.example.moviematchbackend.models.entity.Film;
import com.example.moviematchbackend.models.entity.Prietenie;
import com.example.moviematchbackend.models.entity.StatusCerere;
import com.example.moviematchbackend.models.entity.Utilizator;
import com.example.moviematchbackend.models.mapper.FilmMapper;
import com.example.moviematchbackend.services.film_service.FilmService;
import com.example.moviematchbackend.services.pereche_service.PerecheService;
import com.example.moviematchbackend.services.utilizator_service.UtilizatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.metal.MetalIconFactory;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//acea clasa care imi face legatura dintre frontend si backend


@RestController
public class FilmController {

    @Autowired
    private UtilizatorService utilizatorService;
    @Autowired
    private PerecheService perecheService;
    private final FilmService filmService;
    private final FilmMapper filmMapper;

    @Autowired
    public FilmController(FilmService filmService, FilmMapper filmMapper, PerecheService perecheService,
                          UtilizatorService utilizatorService) {
        this.filmService = filmService;
        this.filmMapper = filmMapper;
        this.perecheService = perecheService;
        this.utilizatorService = utilizatorService;
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
    @GetMapping("/api/random_movies")
    List<Film> getRandomMovies(Authentication authentication){
        String user_email = ((DefaultOidcUser) authentication.getPrincipal()).getEmail();
        Utilizator user_curent = utilizatorService.getUtilizatorByEmail(user_email);
        List<Film> filme = filmService.getAllFilme();
        List<Film> yourMovies = perecheService.getMoviesToSee(user_curent);
        List<Film> result = new ArrayList<>();
        filme.removeAll(yourMovies);
        LocalDate localDate = LocalDate.now();
        Random rnd = new Random(Timestamp.valueOf(localDate.atStartOfDay()).getTime());
        int i = 0,y;
        List<Integer> randoms = new ArrayList<>();
        while(i<10){
            y = rnd.nextInt(filme.size());
            if(!randoms.contains(y)){
                randoms.add(y);
                i++;
            }
        }
        for(Integer k: randoms){
            result.add(filme.get(k));
        }
        return result;
    }

    @GetMapping("/api/filter_movie/")
    public List<FilmDto> emptyfilter(){
        return getFilme();
    }

    @GetMapping("/api/filme/categorii/")
    public List<String> getCategories(){ return filmService.getCategories();}
//    @GetMapping("/api/genre_number")
//    public Integer getNumberOfGenre() {
//        return filmService.fil().size();
//    }

//    @GetMapping("/api/number_filme/gen/{gen}")
//    public Integer getNumberOfMoviesForGenre(@PathVariable String gen) {
//        return filmService.groupMoviesByGenre().get(gen).size();
//    }
}