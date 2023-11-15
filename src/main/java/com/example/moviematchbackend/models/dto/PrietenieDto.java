package com.example.moviematchbackend.models.dto;

public class PrietenieDto {

    private Long idUtilizator1;
    private Long idUtilizator2;

    public PrietenieDto() {
    }

    public PrietenieDto(Long idUtilizator1, Long idUtilizator2) {
        this.idUtilizator1 = idUtilizator1;
        this.idUtilizator2 = idUtilizator2;
    }

    public Long getIdUtilizator1() {
        return idUtilizator1;
    }

    public void setIdUtilizator1(Long idUtilizator1) {
        this.idUtilizator1 = idUtilizator1;
    }

    public Long getIdUtilizator2() {
        return idUtilizator2;
    }

    public void setIdUtilizator2(Long idUtilizator2) {
        this.idUtilizator2 = idUtilizator2;
    }

}
