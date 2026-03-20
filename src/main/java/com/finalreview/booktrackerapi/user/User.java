package com.finalreview.booktrackerapi.user;

import com.finalreview.booktrackerapi.security.PasswordHasher;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String password;
    private String bio;

    public User(Long userId, String username, String password, String bio) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.bio = "No bio yet";
    }
    public User(String username, String password, String bio) {
        this.username = username;
        this.password = password;
        this.bio = "No bio yet";
    }

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
