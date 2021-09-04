package com.example.apiathlete.dto.mapper;

import com.example.apiathlete.domain.Athlete;
import com.example.apiathlete.dto.request.AthleteDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public abstract class AthleteMapper {

    public abstract Athlete toModel(AthleteDTO dto);
    public abstract AthleteDTO toDTO(Athlete athlete);
}
