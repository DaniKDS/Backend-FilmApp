package com.example.moviematchbackend.models.dto;

public class PerecheDto {

    private Long idPereche;

    private Long idFilm;

    private Long idUtilizator;

    public PerecheDto() {
    }

    public PerecheDto(Long idPereche, Long idFilm, Long idUtilizator) {
        this.idPereche = idPereche;
        this.idFilm = idFilm;
        this.idUtilizator = idUtilizator;
    }

    public Long getIdPereche() {
        return idPereche;
    }

    public void setIdPereche(Long idPereche) {
        this.idPereche = idPereche;
    }

    public Long getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Long idFilm) {
        this.idFilm = idFilm;
    }

    public Long getIdUtilizator() {
        return idUtilizator;
    }

    public void setIdUtilizator(Long idUtilizator) {
        this.idUtilizator = idUtilizator;
    }

}
