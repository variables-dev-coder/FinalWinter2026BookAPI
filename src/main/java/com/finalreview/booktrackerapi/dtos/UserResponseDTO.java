package com.finalreview.booktrackerapi.dtos;

public record UserResponseDTO(
        Long id,
        String username,
        String bio
){}