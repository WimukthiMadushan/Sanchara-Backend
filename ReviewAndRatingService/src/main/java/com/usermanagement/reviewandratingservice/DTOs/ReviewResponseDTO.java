package com.usermanagement.reviewandratingservice.DTOs;

public record ReviewResponseDTO(
        int reviewID,
        int eventID,
        int userID,
        String userName,
        int rating,
        String comment
) {
}
