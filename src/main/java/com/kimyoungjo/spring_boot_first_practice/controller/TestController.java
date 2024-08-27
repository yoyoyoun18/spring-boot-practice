package com.kimyoungjo.spring_boot_first_practice.controller;

import com.kimyoungjo.spring_boot_first_practice.model.Member;
import com.kimyoungjo.spring_boot_first_practice.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping("/test")
    public List<Member> getAllMembers() {
        List<Member> members = testService.getAllMembers();
        return members;
    }
}
