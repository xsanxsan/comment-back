package com.example.demo.adapters.out.dbentity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentReplyRepository extends JpaRepository<CommentReplyEntity, Integer> {
}
