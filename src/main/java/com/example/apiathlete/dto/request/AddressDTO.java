package com.example.apiathlete.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO  {

    private Integer id;

    @NotEmpty @NotBlank
    private String streetName;

    private String complement;

    @NotEmpty @NotBlank
    private String cep;

    @Valid
    @NotNull
    private CityDTO city;

}