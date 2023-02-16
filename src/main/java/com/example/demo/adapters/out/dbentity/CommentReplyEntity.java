package com.example.demo.adapters.out.dbentity;

import com.example.demo.domain.CommentReply;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Table(name = "comment_reply")
@NoArgsConstructor
public class CommentReplyEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @Column(nullable = false)
    String content;
    @CreationTimestamp
    LocalDateTime createdAt;
    @Column(nullable = false)
    Integer score;
//    @Column(nullable = false)
//    User user;
    @Column(nullable = false)
    Boolean isEdited;

    @Column
    String replyingTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="comment_id", nullable = false, referencedColumnName = "id")
    private CommentEntity comment;

    public CommentReplyEntity(Integer id, String content, LocalDateTime createdAt, Integer score, Boolean isEdited, String replyingTo, CommentEntity comment) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.score = score;
        this.isEdited = isEdited;
        this.replyingTo = replyingTo;
        this.comment = comment;
    }

    public CommentReplyEntity(CommentReply commentReply, CommentEntity comment) {
        this(commentReply.getId(), commentReply.getContent(), commentReply.getCreatedAt(), commentReply.getScore(), commentReply.getIsEdited(), commentReply.getReplyingTo(), comment);
    }

    public CommentReply toDomain() {
        return CommentReply.builder()
                .id(getId())
                .replyingTo(getReplyingTo())
                .content(getContent())
                .createdAt(getCreatedAt())
                .isEdited(getIsEdited())
                .score(getScore())
                .build();
    }
}
