package com.sanchaara.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Combines @Configuration, @EnableAutoConfiguration, @ComponentScan
public class SanchaaraApplication { // Change YourApplicationName

    public static void main(String[] args) {
        SpringApplication.run(SanchaaraApplication.class, args);
        System.out.println("Spring Boot SanChaara backend started!");
        System.out.println("Access API at http://localhost:8080/api/auth/...");

    }
   
}

