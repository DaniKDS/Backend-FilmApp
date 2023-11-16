package com.example.moviematchbackend.services.prietenie_service;

import com.example.moviematchbackend.models.mapper.Prietenie;
import com.example.moviematchbackend.repositories.PrietenieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//acea clasa care imi face legatura dintre frontend si backend

@Service
public class PrietenieService implements PrietenieServiceInterface {

    @Autowired
    //acest obiect este folosit pentru a apela metodele din clasa PrietenieRepository
    private PrietenieRepository prietenieRepository;
    //acest constructor este folosit pentru a crea un obiect de tip PrietenieService
    public PrietenieService(PrietenieRepository prietenieRepository) {
        this.prietenieRepository = prietenieRepository;
    }

    //acesta metoda imi returneaza toate prieteniile din baza de date in format json
    @Override
    public List<Prietenie> getAllPrietenii() {
        List<Prietenie> listOfPrietenii = new ArrayList<>();
        this.prietenieRepository.findAll().forEach(prietenie -> listOfPrietenii.add(prietenie));
        return listOfPrietenii;
    }
    //acesta metoda imi returneaza toate prieteniile din baza de date

    @Override
    public Prietenie getPrietenieById(Long idPrietenie) {
        return this.prietenieRepository.getPrietenieByIdPrietenie(idPrietenie);
    }
    //acesta metoda imi returneaza o prietenie dupa id in format json

    @Override
    public Prietenie savePrietenie(Prietenie prietenie) {
        return this.prietenieRepository.save(prietenie);
    }
    //acesta metoda imi adauga o prietenie in baza de date
    @Override
    public void deletePrietenie(Prietenie prietenie) {
        this.prietenieRepository.delete(prietenie);
    }


}
