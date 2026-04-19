package com.finalreview.booktrackerapi.user;

import com.finalreview.booktrackerapi.dtos.AuthResponse;
import com.finalreview.booktrackerapi.dtos.UserLoginCredentials;
import com.finalreview.booktrackerapi.dtos.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String test() {
        return "User controller is working!";
    }
    
    @PostMapping("/createUser")
    public ResponseEntity<UserResponseDTO> saveNewUser(@RequestBody User user) {

        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok(userService.saveUser(user));
    }
    
    @GetMapping("/getAllUsers")
    public ResponseEntity<Iterable<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @PostMapping("/verifyUser")
    public ResponseEntity<?> verifyUser(@RequestBody UserLoginCredentials userLoginCredentials) {
        String username = userLoginCredentials.username();
        String password = userLoginCredentials.password();
        boolean isValid = userService.verifyUser(username, password);
        if (!isValid) {
            return ResponseEntity.badRequest().body(new AuthResponse("Invalid username or password please try again", username));
        }
        return ResponseEntity.ok(new AuthResponse("Login successful", username));
    }
}
