package com.kimyoungjo.spring_boot_first_practice.service;

import com.kimyoungjo.spring_boot_first_practice.dto.UserDto;
import com.kimyoungjo.spring_boot_first_practice.model.User;
import com.kimyoungjo.spring_boot_first_practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto.Response createUser(UserDto.Request userDto) {
        // 이메일 중복 체크
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new RuntimeException("이미 사용 중인 이메일입니다.");
        }

        // 사용자명 중복 체크
        if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            throw new RuntimeException("이미 사용 중인 사용자명입니다.");
        }

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());

        // User 엔티티 생성 및 저장
        User user = User.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(encodedPassword)
                .build();

        User savedUser = userRepository.save(user);

        // UserDto.Response 생성 및 반환
        return UserDto.Response.builder()
                .userId(savedUser.getUserId())
                .username(savedUser.getUsername())
                .email(savedUser.getEmail())
                .createdAt(savedUser.getCreatedAt())
                .build();
    }
}
