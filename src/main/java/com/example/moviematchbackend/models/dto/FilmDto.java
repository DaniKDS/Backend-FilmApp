package com.example.moviematchbackend.models.dto;


//aceasta clasa este folosita pentru a trimite datele despre un film catre frontend in momentul in care se face
// o cerere de tip GET catre /film sau /film/{id_film} (in functie de caz)
// este util deoarece nu trimitem toate datele despre un film, ci doar cele necesare, pentru a nu incarca serverul

//dto = data transfer object (obiect de transfer de date) - este o clasa care contine doar datele necesare pentru a fi trimise
// catre frontend, in loc de toate datele despre un film

//sunt utile pentru ca nu incarca serverul cu date inutile

public class FilmDto {

    private Long id_film;
    private String titlu;
    private String gen;
    private int durata;
    private String descriere;
    private int an;

    public FilmDto() {
    }

    public Long getId_film() {
        return id_film;
    }

    public void setId_film(Long id_film) {
        this.id_film = id_film;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

}
