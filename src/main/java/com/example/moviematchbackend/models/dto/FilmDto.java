package com.example.moviematchbackend.models.dto;


//aceasta clasa este folosita pentru a trimite datele despre un film catre frontend in momentul in care se face
// o cerere de tip GET catre /film sau /film/{id_film} (in functie de caz)
// este util deoarece nu trimitem toate datele despre un film, ci doar cele necesare, pentru a nu incarca serverul

//dto = data transfer object (obiect de transfer de date) - este o clasa care contine doar datele necesare pentru a fi trimise
// catre frontend, in loc de toate datele despre un film

//sunt utile pentru ca nu incarca serverul cu date inutile

public class FilmDto {

    private Long idFilm;
    private String titluFilm;
    private String genFilm;
    private int durataFilm;
    private String descriereFilm;
    private int anFilm;

    public FilmDto() {
    }

    public FilmDto(Long idFilm, String titluFilm, String genFilm, int durataFilm, String descriereFilm, int anFilm) {
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
