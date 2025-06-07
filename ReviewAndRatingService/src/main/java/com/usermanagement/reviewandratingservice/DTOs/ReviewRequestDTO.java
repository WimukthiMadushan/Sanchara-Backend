package com.usermanagement.reviewandratingservice.DTOs;

public record ReviewRequestDTO(
        int eventID,
        int userID,
        String userName,
        int rating,
        String comment
) {
}
