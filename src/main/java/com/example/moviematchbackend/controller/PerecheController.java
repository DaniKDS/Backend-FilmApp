package com.example.moviematchbackend.controller;


import com.example.moviematchbackend.models.mapper.Film;
import com.example.moviematchbackend.models.mapper.Pereche;
import com.example.moviematchbackend.models.mapper.Utilizator;
import com.example.moviematchbackend.services.pereche_service.PerecheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.PipedWriter;
import java.util.List;
//acea clasa care imi face legatura dintre frontend si backend
@RestController
public class PerecheController {

    private PerecheService perecheService;
    //acest obiect este folosit pentru a apela metodele din clasa PerecheService
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

//    @GetMapping("/api/perechi/utilizator/{idUtilizator}")
//    public Pereche getPerecheByIdUtilizator(@PathVariable Long idUtilizator) {
//        return perecheService.getPerecheByIdUtilizator(idUtilizator);
//    }

//    @PostMapping("/api/perechi")
//    public void addPereche(@RequestBody Utilizator utilizator, Film film) {
//        this.perecheService.savePereche( utilizator, film);
//    }

}