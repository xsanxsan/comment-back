package com.example.demo.application.usecase;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddCommentCommand {

    @NotBlank
    private String content;

}
