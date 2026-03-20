package com.finalreview.follow;

import com.finalreview.booktrackerapi.dtos.FollowResponseDTO;
import com.finalreview.booktrackerapi.dtos.UserResponseDTO;
import com.finalreview.booktrackerapi.user.User;
import com.finalreview.booktrackerapi.user.UserRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FollowService {

    @Autowired
    private FollowRestRepository followRestRepository;

    @Autowired
    private UserRestRepository userRestRepository;

    public FollowResponseDTO newFollow(Follow follow) {
        Follow savedFollow = followRestRepository.save(follow);
        // Fetch full users to ensure DTO is complete if only IDs were provided
        User follower = userRestRepository.findById(savedFollow.getFollower().getUserId()).orElse(savedFollow.getFollower());
        User followed = userRestRepository.findById(savedFollow.getFollowed().getUserId()).orElse(savedFollow.getFollowed());
        
        return mapToFollowResponseDTO(savedFollow, follower, followed);
    }

    public Iterable<FollowResponseDTO> getAllFollowsForUser(String userName) {
        Iterable<Follow> follows = followRestRepository.findFollowByFollowed_Username(userName);
        return StreamSupport.stream(follows.spliterator(), false)
                .map(follow -> mapToFollowResponseDTO(follow, follow.getFollower(), follow.getFollowed()))
                .collect(Collectors.toList());
    }

    private FollowResponseDTO mapToFollowResponseDTO(Follow follow, User follower, User followed) {
        return new FollowResponseDTO(
                follow.getFollowId(),
                new UserResponseDTO(follower.getUserId(), follower.getUsername(), follower.getBio()),
                new UserResponseDTO(followed.getUserId(), followed.getUsername(), followed.getBio())
        );
    }
}
