package com.example.apiathlete.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {

    private Integer id;
    private String firstName;
    private String lastName;

    private EmailDTO email;
    private AddressDTO address;

}