package com.usermanagement.reviewandratingservice.Service;

import com.usermanagement.reviewandratingservice.DTOs.ReviewRequestDTO;
import com.usermanagement.reviewandratingservice.DTOs.ReviewResponseDTO;
import com.usermanagement.reviewandratingservice.Entity.Review;
import com.usermanagement.reviewandratingservice.Mappers.ReviewMapper;
//import com.usermanagement.reviewandratingservice.Mappers.ReviewResponseMapper;
import com.usermanagement.reviewandratingservice.Repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImplReviewAndRatingService implements ReviewAndRatingService {
    private final ReviewRepository reviewRepository;

    public ImplReviewAndRatingService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<ReviewResponseDTO> findReviewsByEventId(int eventID) {
        List<Review> reviews = reviewRepository.findByEventID(eventID);
        return ReviewMapper.toResponseDTOList(reviews);
    }

    @Override
    public List<ReviewResponseDTO> findReviewsByUserId(int userID) {
        List<Review> reviews = reviewRepository.findByUserID(userID);
        return ReviewMapper.toResponseDTOList(reviews);
    }

    @Override
    public ReviewResponseDTO saveReview(ReviewRequestDTO reviewRequestDTO) {
        Review review = ReviewMapper.toEntity(reviewRequestDTO);
        Review savedReview = reviewRepository.save(review);
        return ReviewMapper.toResponseDTO(savedReview);
    }
}
