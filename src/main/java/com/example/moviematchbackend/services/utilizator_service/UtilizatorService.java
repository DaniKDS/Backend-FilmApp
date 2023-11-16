package com.example.moviematchbackend.services.utilizator_service;

import com.example.moviematchbackend.models.mapper.Utilizator;
import com.example.moviematchbackend.repositories.UtilizatorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilizatorService implements UtilizatorServiceInterface{

    //@Autowired
    private UtilizatorRepository utilizatorRepository;

    public UtilizatorService(UtilizatorRepository utilizatorRepository) {
        this.utilizatorRepository = utilizatorRepository;
    }

    @Override
    public List<Utilizator> getAllUtilizatori() {
        List<Utilizator> listOfUtilizatori = new ArrayList<>();
        this.utilizatorRepository.findAll().forEach(utilizator -> listOfUtilizatori.add(utilizator));
        return listOfUtilizatori;
    }

    @Override
    public Utilizator getUtilizatorById(Long idUtilizator) {
        return this.utilizatorRepository.getUtilizatorByIdUtilizator(idUtilizator);
    }

    @Override
    public Utilizator getUtilizatorByEmail(String email) {
        return this.utilizatorRepository.getUtilizatorByEmail(email);
    }
    @Override
    public Utilizator getUtilizatorByUsername(String usernameUtilizator) {
        return this.utilizatorRepository.getUtilizatorByUsernameUtilizator(usernameUtilizator);
    }

    @Override
    public Utilizator saveUtilizator(Utilizator utilizator) {
        return this.utilizatorRepository.save(utilizator);
    }

    @Override
    public void deleteUtilizator(Utilizator utilizator) {
        this.utilizatorRepository.delete(utilizator);
    }
}
