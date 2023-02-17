package com.example.demo.adapters.out.dbentity;

import com.example.demo.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "app_user")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String profileImagePath;

    public UserEntity(User user) {
        this.profileImagePath = user.getProfileImagePath();
        this.username = user.getUsername();
    }
}
