package com.example.apiathlete.dto.mapper;

import com.example.apiathlete.domain.City;
import com.example.apiathlete.dto.request.CityDTO;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {StateMapper.class})
public abstract class CityMapper {

    @Autowired
    private StateMapper stateMapper;

    public CityDTO toDTO(City entity){
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(entity.getId());
        cityDTO.setCityName(entity.getCityName());
        cityDTO.setState(stateMapper.toDTO(entity.getState()));
        return cityDTO;
    }
    public abstract City toModel(CityDTO dto);

}
