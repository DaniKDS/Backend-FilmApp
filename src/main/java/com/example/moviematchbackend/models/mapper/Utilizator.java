package com.example.moviematchbackend.models.mapper;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "utilizator")
public class Utilizator implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUtilizator")
    private Long idUtilizator;

    @Column(name = "nume")
    private String numeUtilizator;

    @Column(name = "prenume")
    private String prenumeUtilizator;

    @Column(name = "username")
    private String usernameUtilizator;

    @Column(name = "parola")
    private String parolaUtilizator;

    @Column(name = "varsta")
    private Integer varstaUtilizator;

    @Column(name = "oras")
    private String orasUtilizator;

    public Utilizator() {
    }

    public Utilizator(Long idUtilizator, String numeUtilizator, String prenumeUtilizator, String usernameUtilizator, String parolaUtilizator, Integer varstaUtilizator, String orasUtilizator) {
        this.idUtilizator = idUtilizator;
        this.numeUtilizator = numeUtilizator;
        this.prenumeUtilizator = prenumeUtilizator;
        this.usernameUtilizator = usernameUtilizator;
        this.parolaUtilizator = parolaUtilizator;
        this.varstaUtilizator = varstaUtilizator;
        this.orasUtilizator = orasUtilizator;
    }

    public Long getIdUtilizator() {
        return idUtilizator;
    }

    public void setIdUtilizator(Long idUtilizator) {
        this.idUtilizator = idUtilizator;
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

    public String getParolaUtilizator() {
        return parolaUtilizator;
    }

    public void setParolaUtilizator(String parolaUtilizator) {
        this.parolaUtilizator = parolaUtilizator;
    }

    public Integer getVarstaUtilizator() {
        return varstaUtilizator;
    }

    public void setVarstaUtilizator(Integer varstaUtilizator) {
        this.varstaUtilizator = varstaUtilizator;
    }

    public String getOrasUtilizator() {
        return orasUtilizator;
    }

    public void setOrasUtilizator(String orasUtilizator) {
        this.orasUtilizator = orasUtilizator;
    }
}
