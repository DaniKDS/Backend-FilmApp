package com.example.moviematchbackend.controller;


import com.example.moviematchbackend.models.mapper.Utilizator;
import com.example.moviematchbackend.services.utilizator_service.UtilizatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtilizatorController {

    private UtilizatorService utilizatorService;
    @Autowired
    public UtilizatorController(UtilizatorService utilizatorService) {
        this.utilizatorService = utilizatorService;
    }

    @GetMapping("/api/utilizatori")
    public List<Utilizator> getUtilizatori() {
        return this.utilizatorService.getAllUtilizatori();
    }

    @GetMapping("/api/utilizatori/{id}")
    public Utilizator getUtilizatorById(Long id) {
        return this.utilizatorService.getUtilizatorById(id);
    }

    @GetMapping("/api/utilizatori/{username}")
    public Utilizator getUtilizatorByUsername(String username) {
        return this.utilizatorService.getUtilizatorByUsername(username);
    }

}
