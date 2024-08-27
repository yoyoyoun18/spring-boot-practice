package com.kimyoungjo.spring_boot_first_practice.repository;

import com.kimyoungjo.spring_boot_first_practice.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
