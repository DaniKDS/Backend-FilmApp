package com.example.moviematchbackend.models.mapper;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;

import java.io.Serializable;
//aceasta clasa este o clasa de legatura intre clasa Utilizator si clasa Film
@Entity
@Table(name = "prietenie")
public class Prietenie implements Serializable {
    //aceasta clasa este folosita pentru a crea un obiect de tip pereche
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prietenie")
    private Long idPrietenie;

    //aceasta adnotare este folosita pentru a specifica ca atributul este cheie primara
    @ManyToOne
    @JoinColumn(name = "id_utilizator1")
    private Utilizator utilizator1;
    //aceasta adnotare este folosita pentru a specifica relatia dintre tabele
    @ManyToOne
    @JoinColumn(name = "id_utilizator2")
    private Utilizator utilizator2;

    public Prietenie() {
    }

    public Prietenie(Long idPrietenie, Utilizator utilizator1, Utilizator utilizator2) {
        this.idPrietenie = idPrietenie;
        this.utilizator1 = utilizator1;
        this.utilizator2 = utilizator2;
    }

    public Long getIdPrietenie() {
        return idPrietenie;
    }

    public void setIdPrietenie(Long idPrietenie) {
        this.idPrietenie = idPrietenie;
    }

    public Utilizator getUtilizator1() {
        return utilizator1;
    }

    public void setUtilizator1(Utilizator utilizator1) {
        this.utilizator1 = utilizator1;
    }

    public Utilizator getUtilizator2() {
        return utilizator2;
    }

    public void setUtilizator2(Utilizator utilizator2) {
        this.utilizator2 = utilizator2;
    }

}
