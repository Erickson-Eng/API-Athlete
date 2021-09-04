package com.example.apiathlete.dto.mapper;

import com.example.apiathlete.domain.Athlete;
import com.example.apiathlete.dto.request.AthleteDTO;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;


@Mapper(componentModel = "spring",uses = {AddressMapper.class, EmailMapper.class})
public abstract class AthleteMapper {

    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private EmailMapper emailMapper;

    public abstract Athlete toModel(AthleteDTO dto);

    public  AthleteDTO toDTO(Athlete athlete){
        AthleteDTO athleteDTO = new AthleteDTO();
        athleteDTO.setId(athlete.getId());
        athleteDTO.setFirstName(athlete.getFirstName());
        athleteDTO.setLastName(athlete.getLastName());
        athleteDTO.setWeight(athlete.getWeight());
        athleteDTO.setHeight(athlete.getHeight());
        athleteDTO.setEmail(emailMapper.toDTO(athlete.getEmail()));
        athleteDTO.setAddress(addressMapper.toDTO(athlete.getAddress()));
        return athleteDTO;
    }
}
