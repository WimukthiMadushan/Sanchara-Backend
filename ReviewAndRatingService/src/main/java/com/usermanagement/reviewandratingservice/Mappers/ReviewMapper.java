package com.usermanagement.reviewandratingservice.Mappers;

import com.usermanagement.reviewandratingservice.DTOs.ReviewRequestDTO;
import com.usermanagement.reviewandratingservice.DTOs.ReviewResponseDTO;
import com.usermanagement.reviewandratingservice.Entity.Review;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewMapper {

    private ReviewMapper() {
        // Private constructor to prevent instantiation
    }

    public static ReviewResponseDTO toResponseDTO(Review review) {
        return new ReviewResponseDTO(
                review.getReviewID(),
                review.getEventID(),
                review.getUserID(),
                review.getUserName(),
                review.getRating(),
                review.getComment()
        );
    }

    public static List<ReviewResponseDTO> toResponseDTOList(List<Review> reviews) {
        return reviews.stream()
                .map(ReviewMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static Review toEntity(ReviewRequestDTO reviewRequestDTO) {
        return new Review(
                reviewRequestDTO.eventID(),
                reviewRequestDTO.userID(),
                reviewRequestDTO.userName(),
                reviewRequestDTO.rating(),
                reviewRequestDTO.comment()
        );
    }
}
