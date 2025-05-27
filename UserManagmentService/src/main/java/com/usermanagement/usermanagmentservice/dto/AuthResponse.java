package com.usermanagement.usermanagmentservice.dto;

public class AuthResponse {
    private String message;
    private String token; // For JWT, if you implement it
    private Long userId;
    private String email;
    // Add other user details if needed, but be careful not to expose sensitive info

    public AuthResponse(String message) {
        this.message = message;
    }

    public AuthResponse(String message, Long userId, String email) {
        this.message = message;
        this.userId = userId;
        this.email = email;
    }

    public AuthResponse(String message, String token, Long userId, String email) {
        this.message = message;
        this.token = token;
        this.userId = userId;
        this.email = email;
    }


    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}