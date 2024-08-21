package com.kimyoungjo.spring_boot_first_practice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class CommentDto {
    @Getter
    @Setter
    @Builder
    public static class Request {
        private String content;
        private String userId;  // 댓글을 작성하는 사용자의 ID
        private String postId;  // 댓글이 달린 포스트의 ID
    }

    @Getter
    @Setter
    @Builder
    public static class Response {
        private String commentId;
        private String content;
        private String username;  // 작성자 이름
        private LocalDateTime createdAt;
    }
}
