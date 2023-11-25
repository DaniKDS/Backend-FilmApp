package com.example.moviematchbackend.models.dto;

import lombok.Builder;

// Această clasă este folosită pentru a transfera datele despre o prietenie din baza de date către frontend
@Builder
public class UtilizatorDto {


    private String numeUtilizator;

    private String prenumeUtilizator;

    private String username;

    private String email;

}
