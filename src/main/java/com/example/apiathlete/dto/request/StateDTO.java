package com.example.apiathlete.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StateDTO {

    private Integer id;
    private String stateName;
    private String uf;
    private List<CityDTO> cities = new ArrayList<>();

}