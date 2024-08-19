package com.kimyoungjo.spring_boot_first_practice.repository;

import com.kimyoungjo.spring_boot_first_practice.entity.CustomData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DataRepository extends JpaRepository<CustomData, Long> {
    Optional<CustomData> findByUsername(String username);
    Optional<CustomData> findByEmail(String email);
}