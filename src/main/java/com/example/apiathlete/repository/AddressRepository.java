package com.example.apiathlete.repository;

import com.example.apiathlete.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}