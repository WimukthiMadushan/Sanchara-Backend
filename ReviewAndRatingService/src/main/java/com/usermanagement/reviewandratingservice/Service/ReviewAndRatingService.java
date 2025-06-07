package com.usermanagement.reviewandratingservice.Service;

import com.usermanagement.reviewandratingservice.DTOs.ReviewRequestDTO;
import com.usermanagement.reviewandratingservice.DTOs.ReviewResponseDTO;

import java.util.List;

public interface ReviewAndRatingService {

    List<ReviewResponseDTO> findReviewsByEventId(int eventID);

    List<ReviewResponseDTO> findReviewsByUserId(int userID);

    ReviewResponseDTO saveReview(ReviewRequestDTO reviewRequestDTO);
}
