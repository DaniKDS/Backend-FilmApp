package com.example.moviematchbackend.models.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.example.moviematchbackend.models.dto.UtilizatorDto;
import com.example.moviematchbackend.models.entity.Utilizator;

import java.util.List;

@Mapper
public interface UtilizatorMapper {
    UtilizatorMapper INSTANCE = Mappers.getMapper(UtilizatorMapper.class);

    @Mapping(target = "username", source = "usernameUtilizator")
    @Mapping(target ="email", source = "emailUtilizator")
    UtilizatorDto utilizatorToUtilizatorDto(Utilizator utilizator);

    Utilizator utilizatorDtoToUtilizator(UtilizatorDto utilizatorDto);

    List<UtilizatorDto> utilizatoriToUtilizatorDtoList(List<Utilizator> utilizatori);

    List<Utilizator> utilizatorDtoListToUtilizator(List<UtilizatorDto> utilizatorDtoList);
}

//@Mapper: Anotarea care indică că această interfață este folosită pentru generarea codului MapStruct.
//    INSTANCE: O variabilă statică pentru a obține o instanță a maperului generat.
//    Metodele utilizatorToUtilizatorDto și utilizatorDtoToUtilizator: Acestea definesc reguli de mapare între câmpurile
//    obiectelor Utilizator și UtilizatorDto.
//    Metodele implicite utilizatoriToUtilizatorDtoList și utilizatorDtoListToUtilizator: Acestea definesc maparea între
//    liste de obiecte Utilizator și UtilizatorDto.