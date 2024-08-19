package com.kimyoungjo.spring_boot_first_practice.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ApiController {
    @GetMapping("/api/data")
    public String getData() {
        return "This is data from the Spring Boot API!";
    }
}
