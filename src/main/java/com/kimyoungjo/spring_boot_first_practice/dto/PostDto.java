package com.kimyoungjo.spring_boot_first_practice.dto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class PostDto {
    @Getter
    @Setter
    @Builder
    public static class Request {
        private String title;
        private String content;
        private String userId;  // 포스트를 작성하는 사용자의 ID
    }

    @Getter
    @Setter
    @Builder
    public static class Response {
        private String postId;
        private String title;
        private String content;
        private String username;  // 작성자 이름
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }
}
