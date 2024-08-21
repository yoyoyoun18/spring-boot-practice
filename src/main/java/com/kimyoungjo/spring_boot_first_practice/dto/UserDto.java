package com.kimyoungjo.spring_boot_first_practice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class UserDto {
    @Getter
    @Setter
    @Builder
    public static class Request {
        private String username;
        private String email;
        private String password;
    }

    @Getter
    @Setter
    @Builder
    public static class Response {
        private String userId;
        private String username;
        private String email;
        private LocalDateTime createdAt;
    }
}
