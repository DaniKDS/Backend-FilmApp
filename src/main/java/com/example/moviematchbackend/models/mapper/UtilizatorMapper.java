package com.example.moviematchbackend.models.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.example.moviematchbackend.models.dto.UtilizatorDto;
import com.example.moviematchbackend.models.entity.Utilizator;

import java.util.List;

@Mapper//    @Mapper: Anotarea care indică că această interfață este folosită pentru generarea codului MapStruct.
        //    INSTANCE: O variabilă statică pentru a obține o instanță a maperului generat.
public interface UtilizatorMapper {
    UtilizatorMapper INSTANCE = Mappers.getMapper(UtilizatorMapper.class);

    @Mapping(target = "username", source = "usernameUtilizator")
    @Mapping(target ="email", source = "emailUtilizator")
    UtilizatorDto utilizatorToUtilizatorDto(Utilizator utilizator);

    Utilizator utilizatorDtoToUtilizator(UtilizatorDto utilizatorDto);
    // Această metodă converteste un obiect de tip UtilizatorDto într-un obiect de tip Utilizator

    List<UtilizatorDto> utilizatoriToUtilizatorDtoList(List<Utilizator> utilizatori);
    // Această metodă converteste o listă de obiecte de tip Utilizator într-o listă de obiecte de tip UtilizatorDto

    List<Utilizator> utilizatorDtoListToUtilizator(List<UtilizatorDto> utilizatorDtoList);
    // Această metodă converteste o listă de obiecte de tip UtilizatorDto într-o listă de obiecte de tip Utilizator
}


