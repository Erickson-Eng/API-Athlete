package com.example.apiathlete.repository;

import com.example.apiathlete.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}