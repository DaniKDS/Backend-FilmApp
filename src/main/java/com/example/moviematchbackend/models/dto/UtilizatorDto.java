package com.example.moviematchbackend.models.dto;

public class UtilizatorDto {


    private Long idUtilizator;
    private String numeUtilizator;

    private String prenumeUtilizator;
    private String parola;

    private Integer varstaUtilizator;

    private String orasUtilizator;


    public UtilizatorDto() {
    }

    public UtilizatorDto(Long idUtilizator, String numeUtilizator, String prenumeUtilizator, String parola, Integer varstaUtilizator, String orasUtilizator) {
        this.idUtilizator = idUtilizator;
        this.numeUtilizator = numeUtilizator;
        this.prenumeUtilizator = prenumeUtilizator;
        this.parola = parola;
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

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
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
