package com.example.moviematchbackend.models.mapper;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "pereche")
public class Pereche implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pereche;

    @Column(name = "id_film")
    private Long id_film;

    @Column(name = "id_utilizator")
    private Long id_utilizator;

    public Pereche() {
    }

    public Long getId_pereche() {
        return id_pereche;
    }

    public void setId_pereche(Long id_pereche) {
        this.id_pereche = id_pereche;
    }

    public Long getId_film() {
        return id_film;
    }

    public void setId_film(Long id_film) {
        this.id_film = id_film;
    }

    public Long getId_utilizator() {
        return id_utilizator;
    }

    public void setId_utilizator(Long id_utilizator) {
        this.id_utilizator = id_utilizator;
    }
}
