package com.example.demo.application;

import com.example.demo.domain.Comment;
import com.example.demo.domain.CommentReply;

import java.util.List;
import java.util.Optional;

public interface ICommentDependency {
    List<Comment> getAllComments();

    Optional<Comment> getCommentById(Integer id);

    CommentReply addReply(CommentReply commentReply, Integer repliedCommentId);

    Comment saveComment(Comment comment);

    void deleteCommentRepliesAndComment(Integer commentId);

    Optional<CommentReply> getReplyById(Integer replyId);

    void deleteCommentReply(Integer replyId);
}
