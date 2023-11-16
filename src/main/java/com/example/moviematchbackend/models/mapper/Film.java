package com.example.moviematchbackend.models.mapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "film")
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_film")
    private Long idFilm;

    @Column(name = "titlu")
    private String titluFilm;

    @Column(name = "gen")
    private String genFilm;

    @Column(name = "durata")
    private String durataFilm;

    @Column(name = "descriere")
    private String descriereFilm;

    @JsonIgnore
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pereche> pereche;



    @Column(name = "imagine_film", length = 1000000)
    private byte[] imagineFilm;

    public Long getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Long idFilm) {
        this.idFilm = idFilm;
    }

    public String getTitluFilm() {
        return titluFilm;
    }

    public void setTitluFilm(String titluFilm) {
        this.titluFilm = titluFilm;
    }

    public String getGenFilm() {
        return genFilm;
    }

    public void setGenFilm(String genFilm) {
        this.genFilm = genFilm;
    }

    public String getDurataFilm() {
        return durataFilm;
    }

    public void setDurataFilm(String durataFilm) {
        this.durataFilm = durataFilm;
    }

    public String getDescriereFilm() {
        return descriereFilm;
    }

    public void setDescriereFilm(String descriereFilm) {
        this.descriereFilm = descriereFilm;
    }

    public List<Pereche> getPereche() {
        return pereche;
    }

    public void setPereche(List<Pereche> pereche) {
        this.pereche = pereche;
    }

    @Override
    public String toString() {
        return "Film{" +
            "idFilm=" + idFilm +
            ", titluFilm='" + titluFilm + '\'' +
            ", genFilm='" + genFilm + '\'' +
            ", durataFilm='" + durataFilm + '\'' +
            ", descriereFilm='" + descriereFilm + '\'' +
            ", pereche=" + pereche +
            '}';
    }
}
