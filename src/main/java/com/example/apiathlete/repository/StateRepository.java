package com.example.apiathlete.repository;

import com.example.apiathlete.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Integer> {
}