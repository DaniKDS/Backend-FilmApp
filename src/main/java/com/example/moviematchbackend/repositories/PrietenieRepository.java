package com.example.moviematchbackend.repositories;

import com.example.moviematchbackend.models.mapper.Prietenie;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrietenieRepository extends CrudRepository<Prietenie, Long> {

    Prietenie getPrietenieByIdPrietenie(Long idPrietenie);
    //Aceasta functie returneaza prietenia cu id-ul idPrietenie

    Prietenie findByUtilizator1_IdUtilizatorAndUtilizator2_IdUtilizator(Long idUtilizator1, Long idUtilizator2);

}
