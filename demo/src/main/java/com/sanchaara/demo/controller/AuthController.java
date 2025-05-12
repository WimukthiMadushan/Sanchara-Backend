package com.sanchaara.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; // For @Valid annotation
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanchaara.demo.User;
import com.sanchaara.demo.dto.AuthResponse;
import com.sanchaara.demo.dto.LoginRequest;
import com.sanchaara.demo.dto.MessageResponse;
import com.sanchaara.demo.dto.SignUpRequest;
import com.sanchaara.demo.service.AuthService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600) // Allow all origins for simplicity during development
@RestController
@RequestMapping("/api/auth") // Base path for authentication endpoints
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * Endpoint for user registration (sign up).
     *
     * @param signUpRequest The sign-up request DTO, validated.
     * @return ResponseEntity with a success or error message.
     */
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        try {
            User registeredUser = authService.registerUser(signUpRequest);
            return ResponseEntity
                    .status(HttpStatus.CREATED) // 201 Created
                    .body(new AuthResponse("User registered successfully!", registeredUser.getId(), registeredUser.getEmail()));
        } catch (RuntimeException e) {
            // Catches the "Email is already in use!" exception from the service
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST) // 400 Bad Request
                    .body(new MessageResponse("Error: " + e.getMessage()));
        } catch (Exception e) {
            // Generic error handler
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR) // 500 Internal Server Error
                    .body(new MessageResponse("Error: Could not register user. " + e.getMessage()));
        }
    }

    /**
     * Endpoint for user login (sign in).
     *
     * @param loginRequest The login request DTO, validated.
     * @return ResponseEntity with user details upon successful login or an error message.
     */
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            Optional<User> userOptional = authService.loginUser(loginRequest);

            if (userOptional.isPresent()) {
                User user = userOptional.get();
                // For now, just return a success message and user info.
                // Later, you would generate and return a JWT here.
                return ResponseEntity.ok(new AuthResponse("Login successful!", user.getId(), user.getEmail()));
            } else {
                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED) // 401 Unauthorized
                        .body(new MessageResponse("Error: Invalid email or password."));
            }
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR) // 500 Internal Server Error
                    .body(new MessageResponse("Error: Login failed. " + e.getMessage()));
        }
    }

     // --- Example for JWT based login response ---
    /*
    @PostMapping("/signin-jwt")
    public ResponseEntity<?> authenticateUserJwt(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            String jwt = authService.authenticateAndGenerateToken(loginRequest);
            // You might want to get user details to return as well
            // UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            // User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

            return ResponseEntity.ok(new JwtResponse(jwt, user.getId(), user.getEmail(), user.getRoles())); // Assuming JwtResponse DTO
        } catch (AuthenticationException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new MessageResponse("Error: Invalid credentials."));
        } catch (Exception e) {
             return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Error: Login failed. " + e.getMessage()));
        }
    }
    */
}