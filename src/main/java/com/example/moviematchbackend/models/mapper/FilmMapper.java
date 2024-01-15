package com.example.moviematchbackend.models.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.example.moviematchbackend.models.dto.FilmDto;
import com.example.moviematchbackend.models.entity.Film;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Mapper //Anotarea Mapper este folosita pentru a genera codul necesar pentru a converti un
        // obiect de tip Film in FilmDto si invers
@Component //Anotarea Component este folosita pentru a marca clasa ca fiind un bean
            //Clasa Mapper este folosita pentru a converti un obiect de tip Film in FilmDto si invers
public interface FilmMapper {
    FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);

    @Mapping(target = "locatieFilmare", source = "locatieFilmare")
    FilmDto filmToFilmDto(Film film);

    Film filmDtoToFilm(FilmDto filmDto);

    default List<FilmDto> filmeToFilmDtoList(List<Film> filme) {
        return filme.stream()
            .map(this::filmToFilmDto)
            .collect(Collectors.toList());
    }
    // Această metodă converteste o listă de obiecte de tip Film într-o listă de obiecte de tip FilmDto

    default List<Film> filmDtoListToFilm(List<FilmDto> filmDtoList) {
        return filmDtoList.stream()
            .map(this::filmDtoToFilm)
            .collect(Collectors.toList());
    }
    // Această metodă converteste o listă de obiecte de tip FilmDto într-o listă de obiecte de tip Film
}

