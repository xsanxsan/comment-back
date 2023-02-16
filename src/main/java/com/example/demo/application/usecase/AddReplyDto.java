package com.example.demo.application.usecase;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AddReplyDto {
    @NotBlank(message = "A comment cannot be empty")
    String replyContent;
    @NotNull(message = "The reply must be linked to an existing comment")
    Integer repliedCommentId;
    @NotBlank(message = "The reply must reply to an existing user")
    String replyingToUsername;

    public AddReplyDto(String replyContent, Integer repliedCommentId, String replyingToUsername) {
        this.replyContent = replyContent;
        this.repliedCommentId = repliedCommentId;
        this.replyingToUsername = replyingToUsername;
    }

}
