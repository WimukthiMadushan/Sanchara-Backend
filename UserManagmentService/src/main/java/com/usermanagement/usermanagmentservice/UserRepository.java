package com.usermanagement.usermanagmentservice;

// import com.example.yourproject.model.User; // Adjust import if User class is in a different package
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Method to find a user by their email
    Optional<User> findByEmail(String email);

    // Method to check if a user exists by their email
    Boolean existsByEmail(String email);
}