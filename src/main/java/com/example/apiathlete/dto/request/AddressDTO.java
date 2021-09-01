package com.example.apiathlete.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO  {

    private Integer id;
    private String streetName;
    private String complement;
    private String cep;
    private CityDTO city;

}