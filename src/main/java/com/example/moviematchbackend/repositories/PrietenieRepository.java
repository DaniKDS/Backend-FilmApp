package com.example.moviematchbackend.repositories;

import com.example.moviematchbackend.models.entity.Prietenie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrietenieRepository extends CrudRepository<Prietenie, Long> {
    Prietenie getPrietenieByIdPrietenie(Long idPrietenie);
}
