package com.example.demo.application.usecase;

import com.example.demo.application.ICommentDependency;
import com.example.demo.domain.Comment;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RemoveCommentUseCase {

    private final ICommentDependency commentDependency;

    public RemoveCommentUseCase(ICommentDependency commentDependency) {
        this.commentDependency = commentDependency;
    }

    public void removeCommentUseCase(Integer commentId) {
        Optional<Comment> commentById = commentDependency.getCommentById(commentId);

        // If comment do not exist, nothing needs to be done, and we can safely return without doing anything
        if (commentById.isEmpty()) return;

        commentDependency.deleteCommentRepliesAndComment(commentId);
    }
}
