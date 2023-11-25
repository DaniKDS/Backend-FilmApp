package com.example.moviematchbackend.models.dto;

import com.example.moviematchbackend.models.entity.Film;
import lombok.Builder;

// Această clasă este folosită pentru a transfera datele despre o pereche de filme din baza de date către frontend
@Builder
public class PerecheDto {

    private Film film1;

    private Film film2;

}
