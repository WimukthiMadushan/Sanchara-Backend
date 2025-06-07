package com.wishlistmanagement.wishlistmanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.wishlistmanagement.wishlistmanagementservice.Repository")
public class WishListManagmentServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(WishListManagmentServiceApplication.class, args);
    }
}

