package com.usermanagement.reviewandratingservice.Controller;

import com.usermanagement.reviewandratingservice.DTOs.ReviewRequestDTO;
import com.usermanagement.reviewandratingservice.DTOs.ReviewResponseDTO;
import com.usermanagement.reviewandratingservice.Entity.Review;
import com.usermanagement.reviewandratingservice.Service.ImplReviewAndRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/api/v1/reviews")
public class ImplReviewAndRatingController  extends AbstractReviewAndRatingController{
    private final List<Review> reviews = new ArrayList<>();
    private final ImplReviewAndRatingService implReviewAndRatingService;
    private static final Logger logger = LoggerFactory.getLogger(ImplReviewAndRatingService.class);

    @Autowired
    public ImplReviewAndRatingController(ImplReviewAndRatingService implReviewAndRatingService) {
        this.implReviewAndRatingService = implReviewAndRatingService;
    }

    @Override
    @GetMapping("/{eventID}")
    public ResponseEntity<List<ReviewResponseDTO>> getReviewsByEventId(@PathVariable int eventID) {
        List<ReviewResponseDTO> reviews = implReviewAndRatingService.findReviewsByEventId(eventID);
        if (reviews.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reviews);
    }

    @Override
    @GetMapping("/user/{userID}")
    public ResponseEntity<List<ReviewResponseDTO>> getReviewsByUserId(@PathVariable int userID) {
        List<ReviewResponseDTO> reviews = implReviewAndRatingService.findReviewsByUserId(userID);
        if (reviews.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reviews);
    }

    @Override
    @PostMapping
    public ResponseEntity<ReviewResponseDTO> postReview(@RequestBody ReviewRequestDTO reviewRequestDTO) {
        ReviewResponseDTO createdReview = implReviewAndRatingService.saveReview(reviewRequestDTO);
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }
    @Override
    public ResponseEntity<?> findAllReviews() {
        return null;
    }

    @Override
    public ResponseEntity<?> findReviewById(Long id) {
        return null;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviews;
    }


    @Override
    public Review getReviewById(Long id) {
        return reviews.stream()
                .filter(review -> review.getReviewID() == id) // Direct comparison
                .findFirst()
                .orElse(null);
    }

    @Override
    public void createReview(Review review) {
        reviews.add(review);
    }

    @Override
    public void deleteReview(Long id) {
        reviews.removeIf(review -> review.getReviewID()==id);
    }
}
