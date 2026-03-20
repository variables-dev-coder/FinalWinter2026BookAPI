package com.finalreview.booktrackerapi.user;

import com.finalreview.booktrackerapi.dtos.UserResponseDTO;
import com.finalreview.booktrackerapi.security.PasswordHasher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRestRepository userRestRepository;

    public UserResponseDTO saveUser(User user) {
        if (userRestRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }
        user.setPassword(PasswordHasher.hashPassword(user.getPassword()));
        User savedUser = userRestRepository.save(user);
        return mapToUserResponseDTO(savedUser);
    }

    public Iterable<UserResponseDTO> getAllUsers() {
        return userRestRepository.findAll().stream().map(this::mapToUserResponseDTO).toList();
    }
    public boolean verifyUser(String username, String password) {
        User user = userRestRepository.findByUsername(username);
        if (user != null && PasswordHasher.verifyPassword(password, user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }


    public UserResponseDTO mapToUserResponseDTO(User user) {
        return new UserResponseDTO(user.getUserId(), user.getUsername(), user.getBio());
    }
}
