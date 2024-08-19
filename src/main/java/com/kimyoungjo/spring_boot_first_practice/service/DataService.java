package com.kimyoungjo.spring_boot_first_practice.service;

import com.kimyoungjo.spring_boot_first_practice.entity.CustomData;
import com.kimyoungjo.spring_boot_first_practice.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    private final DataRepository dataRepository;

    @Autowired
    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public CustomData insertData(String username, String password, String email) {
        CustomData data = new CustomData();
        data.setUsername(username);
        data.setEmail(email);
        data.setPassword(password);
        return dataRepository.save(data);
    }
}
