package com.example.demo.application.usecase;

import com.example.demo.application.ICommentDependency;
import com.example.demo.domain.CommentReply;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RemoveReplyUseCase {
    private final ICommentDependency commentDependency;

    public RemoveReplyUseCase(ICommentDependency commentDependency) {
        this.commentDependency = commentDependency;
    }

    public void removeReply(Integer replyId) {
        Optional<CommentReply> replyById = commentDependency.getReplyById(replyId);

        // If reply do not exist, nothing needs to be done, and we can safely return without doing anything
        if (replyById.isEmpty()) return;

        commentDependency.deleteCommentReply(replyId);
    }
}
