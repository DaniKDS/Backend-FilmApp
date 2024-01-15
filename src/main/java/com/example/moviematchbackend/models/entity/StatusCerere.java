package com.example.moviematchbackend.models.entity;

// În enum-ul StatusCerere sunt definite două constante: ACCEPTATA și IN_ASTEPTARE
public enum StatusCerere {
    ACCEPTATA,
    IN_ASTEPTARE
    ;
    @Override
    public String toString() {
        switch (this){
            case ACCEPTATA:
                return "acceptata";
            case IN_ASTEPTARE :
                return "in asteptare";
            default:
                return null;
        }
    }
}