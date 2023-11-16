package com.example.moviematchbackend.controller;


import com.example.moviematchbackend.models.mapper.Utilizator;
import com.example.moviematchbackend.services.utilizator_service.UtilizatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//acea clasa care imi face legatura dintre frontend si backend
@RestController
public class UtilizatorController {
    //acest obiect este folosit pentru a apela metodele din clasa UtilizatorService
    private UtilizatorService utilizatorService;
    //acest constructor este folosit pentru a crea un obiect de tip UtilizatorController
    @Autowired
    public UtilizatorController(UtilizatorService utilizatorService) {
        this.utilizatorService = utilizatorService;
    }
    //acest endpoint imi returneaza toti utilizatorii din baza de date in format json
    @GetMapping("/api/utilizatori")
    public List<Utilizator> getUtilizatori() {
        return this.utilizatorService.getAllUtilizatori();
    }
    //acest endpoint imi returneaza un utilizator dupa id in format json
    @GetMapping("/api/utilizatori/id/{id}")
    public Utilizator getUtilizatorById(@PathVariable Long id) {
        return this.utilizatorService.getUtilizatorById(id);
    }
    //acest endpoint imi returneaza un utilizator dupa username in format json
    @GetMapping("/api/utilizatori/username/{username}")
    public Utilizator getUtilizatorByUsername(@PathVariable String username) {
        return this.utilizatorService.getUtilizatorByUsername(username);
    }

}
