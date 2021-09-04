package com.example.apiathlete.dto.mapper;

import com.example.apiathlete.domain.Address;
import com.example.apiathlete.dto.request.AddressDTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AddressMapper {

    public abstract AddressDTO toDTO(Address entity);
    public abstract Address toModel(AddressDTO dto);
}
