package com.wishlistmanagement.wishlistmanagmentservice;

import org.springframework.boot.SpringApplication;

public class TestWishListManagmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(WishListManagmentServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
