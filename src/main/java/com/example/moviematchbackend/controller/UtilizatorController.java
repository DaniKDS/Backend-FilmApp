package com.example.moviematchbackend.controller;



import com.example.moviematchbackend.models.dto.UtilizatorDto;
import com.example.moviematchbackend.models.entity.Utilizator;
import com.example.moviematchbackend.models.mapper.UtilizatorMapper;
import com.example.moviematchbackend.services.utilizator_service.UtilizatorService;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
public class UtilizatorController {

    private final UtilizatorService utilizatorService;
    private final UtilizatorMapper utilizatorMapper;

    @Autowired
    public UtilizatorController(UtilizatorService utilizatorService, UtilizatorMapper utilizatorMapper) {
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
    public UtilizatorDto getCurrentUser(Authentication authentication){
       if (authentication == null){
           return new UtilizatorDto();
       }
       String mail = ((DefaultOidcUser) authentication.getPrincipal()).getEmail();
       Utilizator user = utilizatorService.getUtilizatorByEmail(mail);
       return utilizatorMapper.utilizatorToUtilizatorDto(user);
    }
    @GetMapping("/api/filter_user/{searchText}")
    public List<UtilizatorDto> handleFilter(@PathVariable String searchText) {
        List<UtilizatorDto> user = getUtilizatori();
        List<UtilizatorDto> user1 = getUtilizatori();

        // Collect lowercased concatenated names into a set
        Set<String> lowerCaseNames = user1.stream()
                .map(utilizator -> utilizator.getNumeUtilizator().toLowerCase() + utilizator.getPrenumeUtilizator().toLowerCase())
                .collect(Collectors.toSet());

        // Filter users based on lowercase concatenated names present in lowerCaseNames set
        Predicate<UtilizatorDto> nameMatchesSearchText = utilizator -> {
            String fullNameLower = utilizator.getNumeUtilizator().toLowerCase() + utilizator.getPrenumeUtilizator().toLowerCase();
            String searchTextLower = searchText.toLowerCase();
            return fullNameLower.contains(searchTextLower);
        };

        // Apply the filter and collect the matching users
        List<UtilizatorDto> filteredUsers = user.stream()
                .filter(nameMatchesSearchText)
                .collect(Collectors.toList());

        return filteredUsers;
    }
    @GetMapping("/api/filter_user/")
    public List<UtilizatorDto> emptyfilter(){
        return getUtilizatori();
    }

}
