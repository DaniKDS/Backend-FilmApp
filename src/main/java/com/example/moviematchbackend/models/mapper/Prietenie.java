package com.example.moviematchbackend.models.mapper;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "prietenie")
public class Prietenie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prietenie")
    private Long idPrietenie;

    @ManyToOne
    @JoinColumn(name = "id_utilizator1")
    private Utilizator utilizator1;

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
