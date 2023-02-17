package com.example.demo.application.commands;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RemoveCommentCommand {

    @NotNull(message = "The first level comment Id should always be specified. If the deleted comment is first level firstLevelCommentId and deletedCommentId are equals")
    private Integer firstLevelCommentId;

    @NotNull(message = "The deletedCommentId cannot be null")
    private Integer deletedCommentId;
}
