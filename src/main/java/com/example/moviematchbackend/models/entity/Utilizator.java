package com.example.moviematchbackend.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "utilizator")
@Data
@EqualsAndHashCode
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
//AM FOLOSIT LOMBOK PENTRU A NU MAI FOLOSI GETTERI SI SETTERI SI CONSTRUCTORI IN CLASA
public class Utilizator implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilizator")
    private Long idUtilizator;

    @Column(name = "nume")
    private String numeUtilizator;

    @Column(name = "prenume")
    private String prenumeUtilizator;

    @Column(name = "username")
    private String usernameUtilizator;

    @Column(name = "email", unique = true)
    private String emailUtilizator;

}
