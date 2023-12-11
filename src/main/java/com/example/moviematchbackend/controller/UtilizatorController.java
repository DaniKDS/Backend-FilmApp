package com.example.moviematchbackend.controller;


import com.example.moviematchbackend.models.entity.Utilizator;
import com.example.moviematchbackend.services.utilizator_service.UtilizatorService;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//acea clasa care imi face legatura dintre frontend si backend
@RestController
public class UtilizatorController {

    private final UtilizatorService utilizatorService;
    private final UtilizatorMapper utilizatorMapper;

    @Autowired
    public UtilizatorController(UtilizatorService utilizatorService) {
        this.utilizatorService = utilizatorService;
        this.utilizatorMapper = utilizatorMapper;
    }
    //acest endpoint imi returneaza toti utilizatorii din baza de date in format json
    @GetMapping("/api/utilizatori")
    public List<UtilizatorDto> getUtilizatori() {
        List<Utilizator> utilizatori = this.utilizatorService.getAllUtilizatori();
        return utilizatorMapper.utilizatoriToUtilizatorDtoList(utilizatori);
    }
    //acest endpoint imi returneaza un utilizator dupa id in format json
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
    @GetMapping("/api/utilizatori/current")
    public Utilizator getCurrentUser(Authentication authentication){
       String mail = ((DefaultOidcUser) authentication.getPrincipal()).getEmail();
       Utilizator user = utilizatorService.getUtilizatorByEmail(mail);
       return user;
    }

}
