package com.example.moviematchbackend.controller;


import com.example.moviematchbackend.models.entity.Pereche;
import com.example.moviematchbackend.services.pereche_service.PerecheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//acea clasa care imi face legatura dintre frontend si backend
@RestController
public class PerecheController {

    private PerecheService perecheService;

    @Autowired
    public PerecheController(PerecheService perecheService) {
        this.perecheService = perecheService;
    }
    //acest constructor este folosit pentru a crea un obiect de tip PerecheController
    @GetMapping("/api/perechi")
    public List<Pereche> getPerechi() {
        return this.perecheService.getAllPereche();

    }
    //acest endpoint imi returneaza toate perechile din baza de date in format json

    @GetMapping("/api/perechi/{id}")
    public Pereche getPerecheById(@PathVariable Long id) {
        return perecheService.getPerecheById(id);
    }
    //acest endpoint imi returneaza o pereche dupa id in format json

}