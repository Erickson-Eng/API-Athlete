package com.example.apiathlete.dto.mapper;

import com.example.apiathlete.domain.Address;
import com.example.apiathlete.dto.request.AddressDTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AddressMapper {

    public AddressDTO toDTO(Address entity){
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(entity.getId());
        addressDTO.setStreetName(entity.getStreetName());
        addressDTO.setComplement(entity.getComplement());
//        addressDTO.setCity(entity.getCity());
        return addressDTO;
    };
    public abstract Address toModel(AddressDTO dto);
}
