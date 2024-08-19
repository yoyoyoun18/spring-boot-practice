package com.kimyoungjo.spring_boot_first_practice.controller;

import com.kimyoungjo.spring_boot_first_practice.dto.CustomDataDTO;
import com.kimyoungjo.spring_boot_first_practice.entity.CustomData;
import com.kimyoungjo.spring_boot_first_practice.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/data")
public class DataController {
    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping("/insert")
    public CustomData insertData(@RequestBody CustomDataDTO dataDTO) {
        return dataService.insertData(dataDTO.getUsername(), dataDTO.getPassword(), dataDTO.getEmail());
    }
}