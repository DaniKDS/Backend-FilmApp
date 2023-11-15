package com.example.moviematchbackend.models.mapper;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "pereche")
public class Pereche implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPereche;

    @ManyToOne
    @JoinColumn(name = "id_film")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "id_utilizator")
    private Utilizator utilizator;

    public Pereche() {
    }

    public Pereche(Long idPereche, Film film, Utilizator utilizator) {
        this.idPereche = idPereche;
        this.film = film;
        this.utilizator = utilizator;
    }

    public Long getIdPereche() {
        return idPereche;
    }

    public void setIdPereche(Long idPereche) {
        this.idPereche = idPereche;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Utilizator getUtilizator() {
        return utilizator;
    }

    public void setUtilizator(Utilizator utilizator) {
        this.utilizator = utilizator;
    }
}
