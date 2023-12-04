package com.example.moviematchbackend.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;



@Entity
@Table(name = "prietenie")
@Data
@EqualsAndHashCode
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Prietenie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prietenie")
    private Long idPrietenie;

    @ManyToOne
    @JoinColumn(name = "id_utilizator1", referencedColumnName = "id_utilizator", nullable = false)
    private Utilizator utilizator1;

    @ManyToOne
    @JoinColumn(name = "id_utilizator2", referencedColumnName = "id_utilizator", nullable = false)
    private Utilizator utilizator2;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_cerere")
    private StatusCerere statusCerere;
}
