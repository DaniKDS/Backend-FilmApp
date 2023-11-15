package com.example.moviematchbackend.controller;

import com.example.moviematchbackend.services.prietenie_service.PrietenieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrietenieController {

    private PrietenieService prietenieService;

    @Autowired
    public PrietenieController(PrietenieService prietenieService) {
        this.prietenieService = prietenieService;
    }

    @GetMapping("/api/prieteni")
    public String getPrieteni() {
        return this.prietenieService.getAllPrietenii().toString();
    }

    @GetMapping("/api/prieteni/{id}")
    public String getPrietenieById(Long id) {
        return this.prietenieService.getPrietenieById(id).toString();
    }

    @PostMapping("/api/prieteni")
    public void addPrietenie(Long id_utilizator1, Long id_utilizator2) {
        this.prietenieService.savePrietenie(this.prietenieService.getPrietenieById(id_utilizator1));
    }

    @DeleteMapping("/api/prieteni/{id}")
    public void deletePrietenie(Long id) {
        this.prietenieService.deletePrietenie(this.prietenieService.getPrietenieById(id));
    }

}
