package com.example.moviematchbackend.controller;

import com.example.moviematchbackend.models.entity.Prietenie;
import com.example.moviematchbackend.services.prietenie_service.PrietenieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//acea clasa care imi face legatura dintre frontend si backend
@RestController
public class PrietenieController {

    private PrietenieService prietenieService;
    //acest obiect este folosit pentru a apela metodele din clasa PrietenieService
    @Autowired
    public PrietenieController(PrietenieService prietenieService) {
        this.prietenieService = prietenieService;
    }
    //acest constructor este folosit pentru a crea un obiect de tip PrietenieController
    @GetMapping("/api/prieteni")
    public List<Prietenie> getPrieteni() {
        return this.prietenieService.getAllPrietenii();
    }
    //acest endpoint imi returneaza toate prieteniile din baza de date in format json
    @GetMapping("/api/prieteni/{id}")
    public Prietenie getPrietenieById(@PathVariable Long id) {
        return this.prietenieService.getPrietenieById(id);
    }
    //acest endpoint imi returneaza o prietenie dupa id in format json
    @PostMapping("/api/prieteni")
    public void addPrietenie(@RequestBody Long id_utilizator1, Long id_utilizator2) {
        this.prietenieService.savePrietenie(this.prietenieService.getPrietenieById(id_utilizator1));
    }
    //acest endpoint imi adauga o prietenie in baza de date
    @DeleteMapping("/api/prieteni/{id}")
    public void deletePrietenie(@PathVariable Long id) {
        this.prietenieService.deletePrietenie(this.prietenieService.getPrietenieById(id));
    }

}
