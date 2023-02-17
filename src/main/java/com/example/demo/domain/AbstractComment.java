package com.example.demo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
public abstract class AbstractComment {
    Integer id;
    String content;
    @Builder.Default
    LocalDateTime createdAt = LocalDateTime.now();
    @Builder.Default
    Integer score = 0;
    User user;
    @Builder.Default
    Boolean isEdited = false;
}
