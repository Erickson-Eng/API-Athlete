package com.example.apiathlete.dto.request;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AthleteDTO extends ProfileDTO{

    private Double weight;
    private Double height;
}