package com.example.apiathlete.repository;

import com.example.apiathlete.domain.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<Athlete, Integer> {
}