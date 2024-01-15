package com.example.moviematchbackend.models.entity;
// În enum-ul StatusVizionare sunt definite două constante: VAZUT și IN_ASTEPTARE
public enum StatusVizionare {
    VAZUT,
    IN_ASTEPTARE
    ;
    @Override
    public String toString() {
        return switch (this) {
            case VAZUT -> "vazut";
            case IN_ASTEPTARE -> "in asteptare";
            default -> null;

        };
    }
}
