package com.kimyoungjo.spring_boot_first_practice.repository;

import com.kimyoungjo.spring_boot_first_practice.entity.CustomData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<CustomData, Long> {
}