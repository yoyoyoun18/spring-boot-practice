package com.kimyoungjo.spring_boot_first_practice.service;


import com.kimyoungjo.spring_boot_first_practice.model.Member;
import com.kimyoungjo.spring_boot_first_practice.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    MemberRepository memberRepository; // 1 빈 주입
    public List<Member> getAllMembers() {
        return memberRepository.findAll(); // 2 멤버 목록 얻기
    }
}
