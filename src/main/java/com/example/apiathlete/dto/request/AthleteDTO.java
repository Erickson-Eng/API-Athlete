package com.example.apiathlete.dto.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AthleteDTO extends ProfileDTO {

    @NotNull
    private Double weight;
    private Double height;
}