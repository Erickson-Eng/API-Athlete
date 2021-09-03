package com.example.apiathlete.dto.mapper;

import com.example.apiathlete.domain.Athlete;
import com.example.apiathlete.dto.request.AthleteDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AthleteMapper {

    Athlete toModel(AthleteDTO dto);
    AthleteDTO toDTO(Athlete dto);
}
