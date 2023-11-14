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
    private Long id_prietenie;

    @Column(name = "id_utilizator1")
    private Long id_utilizator1;

    @Column(name = "id_utilizator2")
    private Long id_utilizator2;

    public Prietenie() {
    }

    public Long getId_prietenie() {
        return id_prietenie;
    }

    public void setId_prietenie(Long id_prietenie) {
        this.id_prietenie = id_prietenie;
    }

    public Long getId_utilizator1() {
        return id_utilizator1;
    }

    public void setId_utilizator1(Long id_utilizator1) {
        this.id_utilizator1 = id_utilizator1;
    }

    public Long getId_utilizator2() {
        return id_utilizator2;
    }

    public void setId_utilizator2(Long id_utilizator2) {
        this.id_utilizator2 = id_utilizator2;
    }
}
