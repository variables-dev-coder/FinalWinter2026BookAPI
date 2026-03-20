package com.finalreview.follow;

import com.finalreview.booktrackerapi.user.User;
import jakarta.persistence.*;

@Entity
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long followId;
    @ManyToOne
    private User follower;
    @ManyToOne
    private User followed;
    public Follow(User follower, User followed) {
        this.follower = follower;
        this.followed = followed;
    }
    public Follow() {
    }
    public Long getFollowId() {
        return followId;
    }
    public void setFollowId(Long followId) {
        this.followId = followId;
    }
    public User getFollower() {
        return follower;
    }
    public void setFollower(User follower) {
        this.follower = follower;
    }
    public User getFollowed() {
        return followed;
    }
    public void setFollowed(User followed) {
        this.followed = followed;
    }






}
