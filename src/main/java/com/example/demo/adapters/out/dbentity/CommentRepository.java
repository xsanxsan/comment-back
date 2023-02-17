package com.example.demo.adapters.out.dbentity;

import com.example.demo.application.ICommentDependency;
import com.example.demo.domain.Comment;
import com.example.demo.domain.CommentReply;
import com.example.demo.exceptions.CommentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CommentRepository implements ICommentDependency {

    @Autowired
    ICommentRepository commentRepository;
    @Autowired
    ICommentReplyRepository commentReplyRepository;

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll().stream().map(CommentEntity::toDomain).toList();
    }

    @Override
    public Optional<Comment> getCommentById(Integer id) {
        return commentRepository.findById(id).map(CommentEntity::toDomain);
    }

    @Override
    public CommentReply addReply(CommentReply commentReply, Integer repliedCommentId) {
        var commentEntity = commentRepository.findById(repliedCommentId).orElseThrow(CommentNotFoundException::new);
        var replyEntity = new CommentReplyEntity(commentReply, commentEntity);
        return commentReplyRepository.save(replyEntity).toDomain();
    }

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(new CommentEntity(comment))
                .toDomain();
    }


}
