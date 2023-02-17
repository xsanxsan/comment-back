package com.example.demo.domain;

public record User(String username, String profileImagePath) {

    public String getUsername() {
        return username;
    }
    
    public String getProfileImagePath() {
        return profileImagePath;
    }
}
