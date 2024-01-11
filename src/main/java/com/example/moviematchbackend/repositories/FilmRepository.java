package com.example.moviematchbackend.repositories;

import com.example.moviematchbackend.models.entity.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {
    Film getFilmByIdFilm(Long idFilm);
    Film getFilmByTitlu(String titlu);
    List<Film> getFilmeByGen(String gen);
    List<Film> getFilmByLocatieFilmare(String locatieFilmare);

}
