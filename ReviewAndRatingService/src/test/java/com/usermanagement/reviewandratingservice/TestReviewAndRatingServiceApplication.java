package com.usermanagement.reviewandratingservice;

import org.springframework.boot.SpringApplication;

public class TestReviewAndRatingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(ReviewAndRatingServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
