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

    @Column(name = "id_utilizator1")
    private Long idUtilizator1;

    @Column(name = "id_utilizator2")
    private Long idUtilizator2;

    public Prietenie() {
    }

    public Prietenie(Long idPrietenie, Long idUtilizator1, Long idUtilizator2) {
        this.idPrietenie = idPrietenie;
        this.idUtilizator1 = idUtilizator1;
        this.idUtilizator2 = idUtilizator2;
    }

    public Long getIdPrietenie() {
        return idPrietenie;
    }

    public void setIdPrietenie(Long idPrietenie) {
        this.idPrietenie = idPrietenie;
    }

    public Long getIdUtilizator1() {
        return idUtilizator1;
    }

    public void setIdUtilizator1(Long idUtilizator1) {
        this.idUtilizator1 = idUtilizator1;
    }

    public Long getIdUtilizator2() {
        return idUtilizator2;
    }

    public void setIdUtilizator2(Long idUtilizator2) {
        this.idUtilizator2 = idUtilizator2;
    }

}
