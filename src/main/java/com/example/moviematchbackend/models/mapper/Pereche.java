package com.example.moviematchbackend.models.mapper;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "pereche")
public class Pereche implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPereche;

    @Column(name = "id_film")
    private Long idFilm;

    @Column(name = "id_utilizator")
    private Long idUtilizator;

    public Pereche() {
    }

    public Pereche(Long idPereche, Long idFilm, Long idUtilizator) {
        this.idPereche = idPereche;
        this.idFilm = idFilm;
        this.idUtilizator = idUtilizator;
    }

    public Long getIdPereche() {
        return idPereche;
    }

    public void setIdPereche(Long idPereche) {
        this.idPereche = idPereche;
    }

    public Long getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Long idFilm) {
        this.idFilm = idFilm;
    }

    public Long getIdUtilizator() {
        return idUtilizator;
    }

    public void setIdUtilizator(Long idUtilizator) {
        this.idUtilizator = idUtilizator;
    }

}
