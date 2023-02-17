package com.example.demo.adapters.out.dbentity;

import com.example.demo.domain.Comment;
import com.example.demo.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Table(name = "comment")
@NoArgsConstructor
@AllArgsConstructor
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String content;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private Integer score;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
    @Column(nullable = false)
    private Boolean isEdited;

    @OneToMany(mappedBy = "comment", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentReplyEntity> replies;

    public CommentEntity(Comment comment) {
        this.content = comment.getContent();
        this.createdAt = comment.getCreatedAt();
        this.score = comment.getScore();
        this.user = new UserEntity(comment.getUser());
        this.isEdited = comment.getIsEdited();
        this.replies = comment.getReplies().stream().map(commentReply -> new CommentReplyEntity(commentReply, this)).toList();
    }

    public Comment toDomain() {
        return Comment.builder()
                .score(getScore())
                .id(getId())
                .content(getContent())
                .createdAt(getCreatedAt())
                .isEdited(getIsEdited())
                .user(new User(getUser().getUsername(), getUser().getProfileImagePath()))
                .build();
    }
}
