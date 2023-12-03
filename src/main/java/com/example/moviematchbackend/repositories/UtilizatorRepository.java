package com.example.moviematchbackend.repositories;

import com.example.moviematchbackend.models.entity.Utilizator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilizatorRepository extends CrudRepository<Utilizator, Long> {
    Utilizator getUtilizatorByIdUtilizator(Long idUtilizator);
    Utilizator getUtilizatorByUsernameUtilizator(String numeUtilizator);

}
