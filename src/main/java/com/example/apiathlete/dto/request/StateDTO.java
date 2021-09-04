package com.example.apiathlete.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateDTO {

    private Integer id;
    @NotEmpty
    private String stateName;
    @NotEmpty
    @Size(max = 2, min = 2)
    private String uf;
    private List<CityDTO> cities = new ArrayList<>();

}