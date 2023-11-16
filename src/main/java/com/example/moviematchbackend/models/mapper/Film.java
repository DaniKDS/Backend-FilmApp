package com.example.moviematchbackend.models.mapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

@Entity
//aceasta adnotare este folosita pentru a marca o clasa ca o entitate JPA
@Table(name = "film")
//aceasta adnotare este folosita pentru a specifica numele tabelei din baza de date
public class Film implements Serializable {
    //aceasta clasa este folosita pentru a crea un obiect de tip film
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_film")
    private Long idFilm;
    //aceasta adnotare este folosita pentru a specifica ca atributul este cheie primara
    @Column(name = "titlu")
    private String titluFilm;

    @Column(name = "gen")
    private String genFilm;

    @Column(name = "durata")
    private String durataFilm;

    @Column(name = "descriere")
    private String descriereFilm;
    //aceasta adnotare este folosita pentru a specifica numele coloanei din baza de date
    @JsonIgnore
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pereche> pereche;
    //aceasta adnotare este folosita pentru a specifica relatia dintre tabele
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
