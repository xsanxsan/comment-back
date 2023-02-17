package com.example.demo.application.usecase;

import com.example.demo.application.ICommentDependency;
import com.example.demo.domain.Comment;
import com.example.demo.domain.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
public class AddCommentUseCase {

    private ICommentDependency commentDependency;

    public AddCommentUseCase(ICommentDependency commentDependency) {
        this.commentDependency = commentDependency;
    }

    public Comment addCommentUseCase(@Valid AddCommentCommand addCommentCommand) {
        Comment newComment = Comment.builder()
                .content(addCommentCommand.getContent())
                .user(new User("Username", "path/to/image.jpg"))
                .build();
        
        return commentDependency.saveComment(newComment);
    }
}
