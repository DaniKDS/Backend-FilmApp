package com.example.moviematchbackend.controller;

import com.example.moviematchbackend.models.dto.UtilizatorDto;
import com.example.moviematchbackend.models.entity.Utilizator;
import com.example.moviematchbackend.models.mapper.UtilizatorMapper;
import com.example.moviematchbackend.services.utilizator_service.UtilizatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UtilizatorController {

    private final UtilizatorService utilizatorService;
    private final UtilizatorMapper utilizatorMapper;

    @Autowired
    public UtilizatorController(UtilizatorService utilizatorService, UtilizatorMapper utilizatorMapper) {
        this.utilizatorService = utilizatorService;
        this.utilizatorMapper = utilizatorMapper;
    }

    @GetMapping("/api/utilizatori")
    public List<UtilizatorDto> getUtilizatori() {
        List<Utilizator> utilizatori = this.utilizatorService.getAllUtilizatori();
        return utilizatorMapper.utilizatoriToUtilizatorDtoList(utilizatori);
    }

    @GetMapping("/api/utilizatori/id/{id}")
    public UtilizatorDto getUtilizatorById(@PathVariable Long id) {
        Utilizator utilizator = this.utilizatorService.getUtilizatorById(id);
        return utilizatorMapper.utilizatorToUtilizatorDto(utilizator);
    }

    @GetMapping("/api/utilizatori/username/{username}")
    public UtilizatorDto getUtilizatorByUsername(@PathVariable String username) {
        Utilizator utilizator = this.utilizatorService.getUtilizatorByUsername(username);
        return utilizatorMapper.utilizatorToUtilizatorDto(utilizator);
    }

    // Adaugă metoda pentru adăugarea unui utilizator
    @PostMapping("/api/utilizatori")
    public UtilizatorDto addUtilizator(@RequestBody UtilizatorDto utilizatorDto) {
        Utilizator utilizator = utilizatorMapper.utilizatorDtoToUtilizator(utilizatorDto);
        Utilizator savedUtilizator = this.utilizatorService.saveUtilizator(utilizator);
        return utilizatorMapper.utilizatorToUtilizatorDto(savedUtilizator);
    }
}
