package com.example.moviematchbackend.services.prietenie_service;

import com.example.moviematchbackend.models.mapper.Prietenie;
import com.example.moviematchbackend.repositories.PrietenieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrietenieService implements PrietenieServiceInterface {

    //@Autowired
    private PrietenieRepository prietenieRepository;

    public PrietenieService(PrietenieRepository prietenieRepository) {
        this.prietenieRepository = prietenieRepository;
    }


    @Override
    public List<Prietenie> getAllPrietenii() {
        List<Prietenie> listOfPrietenii = new ArrayList<>();
        this.prietenieRepository.findAll().forEach(prietenie -> listOfPrietenii.add(prietenie));
        return listOfPrietenii;
    }

    @Override
    public Prietenie getPrietenieById(Long id) {
        return this.prietenieRepository.getPrietenieByIdPrietenie(id);
    }

    @Override
    public Prietenie savePrietenie(Prietenie prietenie) {
        return this.prietenieRepository.save(prietenie);
    }

    @Override
    public void deletePrietenie(Prietenie prietenie) {
        this.prietenieRepository.delete(prietenie);
    }


}
