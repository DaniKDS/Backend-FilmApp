package com.example.moviematchbackend.models.mapper;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapStructConfig {
    @Bean
    public FilmMapper filmMapper() {
        return Mappers.getMapper(FilmMapper.class);
    }
    // Această metodă returnează un obiect de tip FilmMapper
    @Bean
    public UtilizatorMapper utilizatorMapper() {
        return Mappers.getMapper(UtilizatorMapper.class); // sau UtilizatorMapper.INSTANCE
    }
    // Această metodă returnează un obiect de tip UtilizatorMapper
}
