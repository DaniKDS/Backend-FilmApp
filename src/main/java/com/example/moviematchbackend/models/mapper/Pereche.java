package com.example.moviematchbackend.models.mapper;

import jakarta.persistence.*;

import java.io.Serializable;
//aceasta clasa este o clasa de legatura intre clasa Utilizator si clasa Film
@Entity
@Table(name = "pereche")
public class Pereche implements Serializable {
    //aceasta clasa este folosita pentru a crea un obiect de tip pereche
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPereche;
    //aceasta adnotare este folosita pentru a specifica ca atributul este cheie primara
    @ManyToOne
    @JoinColumn(name = "id_film")
    private Film film;
    //aceasta adnotare este folosita pentru a specifica relatia dintre tabele
    @ManyToOne
    @JoinColumn(name = "id_utilizator")
    private Utilizator utilizator;
    //aceasta adnotare este folosita pentru a specifica relatia dintre tabele
    public Pereche() {
    }

    public Pereche(Long idPereche, Film film, Utilizator utilizator) {
        this.idPereche = idPereche;
        this.film = film;
        this.utilizator = utilizator;
    }

    public Pereche(Utilizator utilizator, Film film) {  //constructor pentru a crea o pereche
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