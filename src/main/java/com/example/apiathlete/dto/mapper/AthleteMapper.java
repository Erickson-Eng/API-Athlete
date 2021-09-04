package com.example.apiathlete.dto.mapper;

import com.example.apiathlete.domain.Address;
import com.example.apiathlete.domain.Athlete;
import com.example.apiathlete.domain.Email;
import com.example.apiathlete.dto.request.AddressDTO;
import com.example.apiathlete.dto.request.AthleteDTO;
import com.example.apiathlete.dto.request.EmailDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring",uses = {AddressMapper.class, EmailMapper.class})
public abstract class AthleteMapper {

    public abstract EmailDTO toDTO(Email entity);
    public abstract AddressDTO toDTO(Address entity);
    public abstract Athlete toModel(AthleteDTO dto);

    public  AthleteDTO toDTO(Athlete athlete){
        AthleteDTO athleteDTO = new AthleteDTO();
        athleteDTO.setId(athlete.getId());
        athleteDTO.setFirstName(athlete.getFirstName());
        athleteDTO.setLastName(athlete.getLastName());
        athleteDTO.setWeight(athlete.getWeight());
        athleteDTO.setHeight(athlete.getHeight());
        athleteDTO.setEmail(toDTO(athlete.getEmail()));
//        athleteDTO.setAddress(toDTO(athlete.getAddress()));
        return athleteDTO;
    }
}
