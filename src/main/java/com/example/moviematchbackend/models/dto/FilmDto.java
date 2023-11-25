package com.example.moviematchbackend.models.dto;

import lombok.Builder;
// Această clasă este folosită pentru a transfera datele despre un film din baza de date către frontend
@Builder
public class FilmDto {

    private String titlu;

    private String descriere;

    private String gen;

    private String durata;

    private String locatieFilmare;

}
