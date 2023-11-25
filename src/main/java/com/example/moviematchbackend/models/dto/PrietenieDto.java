package com.example.moviematchbackend.models.dto;

import lombok.Builder;

// Această clasă este folosită pentru a transfera datele despre o prietenie din baza de date către frontend
@Builder
public class PrietenieDto {

    private UtilizatorDto utilizator1;

    private UtilizatorDto utilizator2;


}
