package com.example.apiathlete.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO  {

    private Integer id;
    private String cityName;
    private StateDTO state;

}