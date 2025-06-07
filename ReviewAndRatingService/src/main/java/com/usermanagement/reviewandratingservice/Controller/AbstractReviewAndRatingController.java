package com.usermanagement.reviewandratingservice.Controller;

import com.usermanagement.reviewandratingservice.DTOs.ReviewRequestDTO;
import com.usermanagement.reviewandratingservice.DTOs.ReviewResponseDTO;
import com.usermanagement.reviewandratingservice.Entity.Review;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class AbstractReviewAndRatingController {

    public abstract ResponseEntity<List<ReviewResponseDTO>> getReviewsByEventId(int eventID);
    public abstract ResponseEntity<List<ReviewResponseDTO>> getReviewsByUserId(int userID);
    public abstract ResponseEntity<ReviewResponseDTO> postReview(ReviewRequestDTO reviewRequestDTO);


    public abstract ResponseEntity<?> findAllReviews();

    public abstract ResponseEntity<?> findReviewById(Long id);

    public abstract List<Review> getAllReviews();

    public abstract Review getReviewById(Long id);

    public abstract void createReview(Review review);

    public abstract void deleteReview(Long id);
}