package com.example.apiathlete.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO  {

    private Integer id;
    @NotEmpty
    private String cityName;
    @NotNull
    @Valid
    private StateDTO state;

}