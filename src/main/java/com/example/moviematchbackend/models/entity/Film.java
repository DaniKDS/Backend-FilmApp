package com.example.moviematchbackend.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "film")
@Data
@EqualsAndHashCode
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

//AM FOLOSIT LOMBOK PENTRU A NU MAI FOLOSI GETTERI SI SETTERI SI CONSTRUCTORI IN CLASA
public class Film implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_film")
    private Long idFilm;

    @Column(name = "titlu")
    private String titlu;

    @Column(name = "gen")
    private String gen;

    @Column(name = "durata")
    private String durata;

    @Column(name = "descriere")
    private String descriere;

    @Column(name = "locatie_filmare") // Adăugarea câmpului pentru locația filmării
    private String locatieFilmare;

    @JsonIgnore
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pereche> pereche;

    @Column(name = "imagine")
    private String imagine;
}
