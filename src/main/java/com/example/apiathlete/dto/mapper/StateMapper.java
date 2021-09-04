package com.example.apiathlete.dto.mapper;

import com.example.apiathlete.domain.State;
import com.example.apiathlete.dto.request.StateDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class StateMapper {

    public StateDTO toDTO(State entity){
        StateDTO stateDTO = new StateDTO();
        stateDTO.setId(entity.getId());
        stateDTO.setStateName(entity.getStateName());
        stateDTO.setUf(entity.getUf());
        return stateDTO;
    }
    public abstract State toModel(StateDTO dto);

}
