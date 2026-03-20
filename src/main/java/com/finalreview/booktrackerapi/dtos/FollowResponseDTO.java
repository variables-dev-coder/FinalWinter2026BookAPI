package com.finalreview.booktrackerapi.dtos;

public record FollowResponseDTO(
        Long followId,
        UserResponseDTO follower,
        UserResponseDTO followed
) {}
