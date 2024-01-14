package com.example.moviematchbackend.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class FilmDto {
    private String titlu;
    private String descriere;
    private String gen;
    private String durata;
    private String locatieFilmare;
    private String imagine;
}

