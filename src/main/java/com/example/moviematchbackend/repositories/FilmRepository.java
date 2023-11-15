package com.example.moviematchbackend.repositories;

import com.example.moviematchbackend.models.mapper.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {
    Film getFilmByIdFilm(Long idFilm);
    //acea metoda care imi returneaza un film dupa id

    Film getFilmByTitluFilm(String titluFilm);
    //acea metoda care imi returneaza un film dupa titlu


}
