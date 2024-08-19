package com.kimyoungjo.spring_boot_first_practice.service;

import com.kimyoungjo.spring_boot_first_practice.entity.CustomData;
import com.kimyoungjo.spring_boot_first_practice.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DataService {
    private final DataRepository dataRepository;

    @Autowired
    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public CustomData insertData(String username, String password, String email) {
        // 중복된 username 검사
        Optional<CustomData> existingUserByUsername = dataRepository.findByUsername(username);
        if (existingUserByUsername.isPresent()) {
            throw new IllegalArgumentException("Username already exists!");
        }
        // 중복된 email 검사
        Optional<CustomData> existingUserByEmail = dataRepository.findByEmail(email);
        if (existingUserByEmail.isPresent()) {
            throw new IllegalArgumentException("Email already exists!");
        }

        // 중복이 없을 경우 데이터 저장
        CustomData data = new CustomData();
        data.setUsername(username);
        data.setEmail(email);
        data.setPassword(password);

        return dataRepository.save(data);
    }
}
