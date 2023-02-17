package com.example.demo.application.usecase;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class AddReplyCommand {
    @NotBlank(message = "A comment cannot be empty")
    private String replyContent;
    @NotNull(message = "The reply must be linked to an existing comment")
    private Integer repliedCommentId;
    @NotBlank(message = "The reply must reply to an existing user")
    private String replyingToUsername;

    public AddReplyCommand(String replyContent, Integer repliedCommentId, String replyingToUsername) {
        this.replyContent = replyContent;
        this.repliedCommentId = repliedCommentId;
        this.replyingToUsername = replyingToUsername;
    }

}
