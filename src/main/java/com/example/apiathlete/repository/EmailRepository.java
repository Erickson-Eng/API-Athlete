package com.example.apiathlete.repository;

import com.example.apiathlete.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Integer> {
}