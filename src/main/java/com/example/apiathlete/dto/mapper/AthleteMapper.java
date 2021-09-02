package com.example.apiathlete.dto.mapper;

import com.example.apiathlete.domain.Athlete;
import com.example.apiathlete.dto.request.AthleteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AthleteMapper {

    AthleteMapper INSTANCE = Mappers.getMapper(AthleteMapper.class);

    Athlete toModel(AthleteDTO athleteDTO);
    AthleteDTO toDTO(Athlete athlete);
}
