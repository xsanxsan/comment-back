package com.example.demo.application.usecase;

import com.example.demo.application.ICommentDependency;
import com.example.demo.domain.Comment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllCommentUseCase {
    private final ICommentDependency commentDependency;
    public GetAllCommentUseCase(ICommentDependency commentDependency) {
        this.commentDependency = commentDependency;
    }

    public List<Comment> getAllCommentUseCase() {
        return commentDependency.getAllComments();
    }
}
