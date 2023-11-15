package com.example.moviematchbackend.models.mapper;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;

import java.io.Serializable;

@Entity
@Table(name = "film")

public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_film")
    private Long idFilm;

    @Column(name = "titlu_film")
    private String titluFilm;

    @Column(name = "gen_film")
    private String genFilm;

    @Column(name = "durata_film")
    private int durataFilm;

    @Column(name = "descriere_film")
    private String descriereFilm;

    @Column(name = "an_film")
    private int anFilm;

    public Film() {
    }

    public Film(Long idFilm, String titluFilm, String genFilm, int durataFilm, String descriereFilm, int anFilm) {
        this.idFilm = idFilm;
        this.titluFilm = titluFilm;
        this.genFilm = genFilm;
        this.durataFilm = durataFilm;
        this.descriereFilm = descriereFilm;
        this.anFilm = anFilm;
    }

    public Long getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Long idFilm) {
        this.idFilm = idFilm;
    }

    public String getTitluFilm() {
        return titluFilm;
    }

    public void setTitluFilm(String titluFilm) {
        this.titluFilm = titluFilm;
    }

    public String getGenFilm() {
        return genFilm;
    }

    public void setGenFilm(String genFilm) {
        this.genFilm = genFilm;
    }

    public int getDurataFilm() {
        return durataFilm;
    }

    public void setDurataFilm(int durataFilm) {
        this.durataFilm = durataFilm;
    }

    public String getDescriereFilm() {
        return descriereFilm;
    }

    public void setDescriereFilm(String descriereFilm) {
        this.descriereFilm = descriereFilm;
    }

    public int getAnFilm() {
        return anFilm;
    }

    public void setAnFilm(int anFilm) {
        this.anFilm = anFilm;
    }
}
