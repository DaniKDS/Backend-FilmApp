package com.example.moviematchbackend.models.entity;

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
