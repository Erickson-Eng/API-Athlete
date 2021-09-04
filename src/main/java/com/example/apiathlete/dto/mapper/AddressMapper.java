package com.example.apiathlete.dto.mapper;

import com.example.apiathlete.domain.Address;
import com.example.apiathlete.dto.request.AddressDTO;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {CityMapper.class, StateMapper.class})
public abstract class AddressMapper {

    @Autowired
    private CityMapper cityMapper;

    public AddressDTO toDTO(Address entity){
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(entity.getId());
        addressDTO.setStreetName(entity.getStreetName());
        addressDTO.setComplement(entity.getComplement());
        addressDTO.setCep(entity.getCep());
        addressDTO.setCity(cityMapper.toDTO(entity.getCity()));
        return addressDTO;
    };
    public abstract Address toModel(AddressDTO dto);
}
