package com.example.apiathlete.dto.mapper;

import com.example.apiathlete.domain.Athlete;
import com.example.apiathlete.dto.request.AthleteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AthleteMapper {
    public static final AthleteMapper INSTANCE = Mappers.getMapper(AthleteMapper.class);

    @Mapping(target = "firstName", source = "firstName")
    public abstract Athlete toModel(AthleteDTO dto);
}
