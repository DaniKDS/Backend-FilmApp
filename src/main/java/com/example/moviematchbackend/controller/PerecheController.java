package com.example.moviematchbackend.controller;


import com.example.moviematchbackend.services.pereche_service.PerecheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerecheController {

    private PerecheService perecheService;
    @Autowired
    public PerecheController(PerecheService perecheService) {
        this.perecheService = perecheService;
    }
    @GetMapping("/api/perechi")
    public String getPerechi() {
        return this.perecheService.getAllPereche().toString();

    }
    @GetMapping("/api/perechi/{id}")
    public String getPerecheById(Long id) {
        return this.perecheService.getPerecheById(id).toString();
    }

    @GetMapping("/api/perechi/{id_utilizator}")
    public String getPerecheByIdUtilizator(Long id_utilizator) {
        return this.perecheService.getPerecheByIdUtilizator(id_utilizator).toString();
    }

    @DeleteMapping("/api/perechi/{id}")
    public void deletePereche(Long id) {
        this.perecheService.deletePereche(this.perecheService.getPerecheById(id));
    }

    @PostMapping("/api/perechi")
    public void addPereche(Long id_utilizator, Long id_film) {
        this.perecheService.savePereche(this.perecheService.getPerecheById(id_utilizator));
    }


}
