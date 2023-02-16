package com.example.demo.domain;

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
    LocalDateTime createdAt;
    Integer score;
    User user;
    Boolean isEdited;
}
