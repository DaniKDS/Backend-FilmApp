package com.example.moviematchbackend.models.mapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

//aceasta clasa este folosita pentru a crea un obiect de tip film
@Entity
@Table(name = "utilizator")
public class Utilizator implements Serializable {
    //aceasta clasa este folosita pentru a crea un obiect de tip utilizator
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilizator")
    private Long idUtilizator;
    //aceasta adnotare este folosita pentru a specifica ca atributul este cheie primara
    @Column(name = "nume")
    private String numeUtilizator;
    //aceasta adnotare este folosita pentru a specifica numele coloanei din baza de date
    @Column(name = "prenume")
    private String prenumeUtilizator;
    //aceasta adnotare este folosita pentru a specifica numele coloanei din baza de date
    @Column(name = "username")
    private String usernameUtilizator;
    //aceasta adnotare este folosita pentru a specifica numele coloanei din baza de date
    @Column(name = "email")
    private String emailUtilizator;

//    @JsonIgnoreProperties("utilizator")
//    @OneToMany(mappedBy = "utilizator", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Pereche> pereche;

//    @JsonIgnoreProperties("prieteni")
//    @OneToMany(mappedBy = "prieteni", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Prietenie> prieteni;

    public Utilizator() {
    }

    public Utilizator(Long idUtilizator, String numeUtilizator, String prenumeUtilizator, String usernameUtilizator, String emailUtilizator) {
        this.idUtilizator = idUtilizator;
        this.numeUtilizator = numeUtilizator;
        this.prenumeUtilizator = prenumeUtilizator;
        this.usernameUtilizator = usernameUtilizator;
        this.emailUtilizator = emailUtilizator;
    }

    public void setIdUtilizator(Long idUtilizator) {
        this.idUtilizator = idUtilizator;
    }

    public Long getIdUtilizator() {
        return idUtilizator;
    }

    public String getNumeUtilizator() {
        return numeUtilizator;
    }

    public void setNumeUtilizator(String numeUtilizator) {
        this.numeUtilizator = numeUtilizator;
    }

    public String getPrenumeUtilizator() {
        return prenumeUtilizator;
    }

    public void setPrenumeUtilizator(String prenumeUtilizator) {
        this.prenumeUtilizator = prenumeUtilizator;
    }

    public String getUsernameUtilizator() {
        return usernameUtilizator;
    }

    public void setUsernameUtilizator(String usernameUtilizator) {
        this.usernameUtilizator = usernameUtilizator;
    }

    public String getEmailUtilizator() {
        return emailUtilizator;
    }

    public void setEmailUtilizator(String emailUtilizator) {
        this.emailUtilizator = emailUtilizator;
    }
}
