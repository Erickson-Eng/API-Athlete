package com.example.apiathlete.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class Athlete extends Profile {
    private static final long serialVersionUID = -8638214819876514147L;
    private Double weight;
    private Double height;
}