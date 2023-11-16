package com.example.moviematchbackend.controller;

import com.example.moviematchbackend.models.mapper.Prietenie;
import com.example.moviematchbackend.services.prietenie_service.PrietenieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PrietenieController {

    private PrietenieService prietenieService;

    @Autowired
    public PrietenieController(PrietenieService prietenieService) {
        this.prietenieService = prietenieService;
    }

    @GetMapping("/api/prieteni")
    public List<Prietenie> getPrieteni() {
        return this.prietenieService.getAllPrietenii();
    }

    @GetMapping("/api/prieteni/{id}")
    public Prietenie getPrietenieById(@PathVariable Long id) {
        return this.prietenieService.getPrietenieById(id);
    }

    @PostMapping("/api/prieteni")
    public void addPrietenie(@RequestBody Long id_utilizator1, Long id_utilizator2) {
        this.prietenieService.savePrietenie(this.prietenieService.getPrietenieById(id_utilizator1));
    }

    @DeleteMapping("/api/prieteni/{id}")
    public void deletePrietenie(@PathVariable Long id) {
        this.prietenieService.deletePrietenie(this.prietenieService.getPrietenieById(id));
    }

}
