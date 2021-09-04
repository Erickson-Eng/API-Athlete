package com.example.apiathlete.dto.mapper;

import com.example.apiathlete.domain.Email;
import com.example.apiathlete.dto.request.EmailDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class EmailMapper {

    public abstract EmailDTO toDTO(Email entity);
    public abstract Email toModel(EmailDTO dto);

}
