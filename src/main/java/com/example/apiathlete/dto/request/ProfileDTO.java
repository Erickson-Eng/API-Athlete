package com.example.apiathlete.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class ProfileDTO {

    private Integer id;
    @NotEmpty
    @Size(min = 2, max = 25, message = "O nome deve conter entre 2 a 25 caracteres")
    private String firstName;
    @NotEmpty
    @Size(min = 2, max = 70, message = "O nome deve conter entre 2 a 70 caracteres")
    private String lastName;

    @Valid
    private EmailDTO email;

    @Valid
    private AddressDTO address;

}