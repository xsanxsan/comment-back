package com.example.demo.application.usecase;

import com.example.demo.application.ICommentDependency;
import com.example.demo.application.commands.AddReplyCommand;
import com.example.demo.domain.CommentReply;
import com.example.demo.exceptions.CommentNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Component
@Validated
public class AddReplyUseCase {

    private final ICommentDependency commentDependency;

    public AddReplyUseCase(ICommentDependency commentDependency) {
        this.commentDependency = commentDependency;
    }

    public CommentReply addReplyUseCase(@Valid AddReplyCommand addReplyCommand) {
        commentDependency.getCommentById(addReplyCommand.getRepliedCommentId()).orElseThrow(CommentNotFoundException::new);

        var reply = CommentReply.builder()
                .replyingTo(addReplyCommand.getReplyingToUsername())
                .content(addReplyCommand.getReplyContent())
                .score(0)
                .createdAt(LocalDateTime.now())
                .isEdited(false)
                .build();

        return commentDependency.addReply(reply, addReplyCommand.getRepliedCommentId());
    }
}
