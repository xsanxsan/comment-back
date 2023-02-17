package com.example.demo.adapters.in.controller;

import com.example.demo.adapters.in.dto.AddCommentDto;
import com.example.demo.application.usecase.*;
import com.example.demo.domain.Comment;
import com.example.demo.domain.CommentReply;
import com.example.demo.domain.User;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class CommentController {
    private final AddReplyUseCase addReplyUseCase;
    private final GetAllCommentUseCase getAllCommentUseCase;

    private final AddCommentUseCase addCommentUseCase;

    public CommentController(AddReplyUseCase addReplyUseCase, GetAllCommentUseCase getAllCommentUseCase, AddCommentUseCase addCommentUseCase) {
        this.addReplyUseCase = addReplyUseCase;
        this.getAllCommentUseCase = getAllCommentUseCase;
        this.addCommentUseCase = addCommentUseCase;
    }

    @CrossOrigin
    @GetMapping(value = "/comments")
    public List<Comment> getAllComments() {
        return getAllCommentUseCase.getAllCommentUseCase();
    }

    @CrossOrigin
    @PostMapping(value = "/comments")
    public Comment addComment(@RequestBody AddCommentDto addCommentDto) {
        return addCommentUseCase.addCommentUseCase(new AddCommentCommand(addCommentDto.content()));
    }

    @CrossOrigin
    @PutMapping(value = "/comments/{id}")
    public Comment editComment(@PathVariable("id") Integer commentId) {
        return Comment.builder().score(2).id(10).content("content").isEdited(false).createdAt(LocalDateTime.now()).user(new User("username", "path/to/profile/pic.jpg")).build();
    }

    @CrossOrigin
    @PutMapping(value = "/comments/{id}/replies/{replyId}")
    public CommentReply editCommentReply(@PathVariable("id") Integer replyId) {
        return CommentReply.builder().replyingTo("fake").score(2).id(10).content("content").isEdited(false).createdAt(LocalDateTime.now()).user(new User("username", "path/to/profile/pic.jpg")).build();
    }

    @CrossOrigin
    @PostMapping(value = "/comments/{id}/replies")
    public CommentReply addReply(@PathVariable("id") Integer commentId) {
        return addReplyUseCase.addReplyUseCase(new AddReplyCommand("fake content", commentId, "fakeUsername"));
    }
}
