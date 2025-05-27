package com.usermanagement.usermanagmentservice.controller;

import com.usermanagement.usermanagmentservice.User;
import com.usermanagement.usermanagmentservice.dto.AuthResponse;
import com.usermanagement.usermanagmentservice.dto.LoginRequest;
import com.usermanagement.usermanagmentservice.dto.MessageResponse;
import com.usermanagement.usermanagmentservice.dto.SignUpRequest;
import com.usermanagement.usermanagmentservice.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    @Operation(summary = "Register a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User registered successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AuthResponse.class))),
            @ApiResponse(responseCode = "400", description = "Email is already in use",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = MessageResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = MessageResponse.class)))
    })
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        try {
            User registeredUser = authService.registerUser(signUpRequest);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new AuthResponse("User registered successfully!", registeredUser.getId(), registeredUser.getEmail()));
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse("Error: " + e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
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
    @Operation(summary = "Authenticate user (login)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login successful",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AuthResponse.class))),
            @ApiResponse(responseCode = "401", description = "Invalid credentials",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = MessageResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = MessageResponse.class)))
    })
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
}
