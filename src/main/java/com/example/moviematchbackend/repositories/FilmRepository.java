package com.example.moviematchbackend.repositories;

import com.example.moviematchbackend.models.entity.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {
    Film getFilmByIdFilm(Long idFilm);

    Film getFilmByTitlu(String titlu);

}
