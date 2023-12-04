package com.example.moviematchbackend.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Această clasă este folosită pentru a transfera datele despre o prietenie din baza de date către frontend
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UtilizatorDto {

    private String numeUtilizator;
    private String prenumeUtilizator;
    private String username;
    private String email;

}
