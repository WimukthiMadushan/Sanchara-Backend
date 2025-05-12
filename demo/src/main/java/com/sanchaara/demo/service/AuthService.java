package com.sanchaara.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanchaara.demo.User;
import com.sanchaara.demo.UserRepository;
import com.sanchaara.demo.dto.LoginRequest; // Import for @Transactional
import com.sanchaara.demo.dto.SignUpRequest;


@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // If you implement JWT, you'll need AuthenticationManager and JwtUtils
    // @Autowired
    // private AuthenticationManager authenticationManager;
    // @Autowired
    // private JwtUtils jwtUtils;


    /**
     * Registers a new user.
     *
     * @param signUpRequest DTO containing user registration details.
     * @return The created User object.
     * @throws RuntimeException if the email is already taken.
     */
    @Transactional // Ensures the operation is atomic
    public User registerUser(SignUpRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new RuntimeException("Error: Email is already in use!");
        }

        // Create new user's account
        User user = new User();
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setDateOfBirth(signUpRequest.getDateOfBirth());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword())); // Hash the password

        return userRepository.save(user);
    }

    /**
     * Authenticates a user.
     *
     * @param loginRequest DTO containing login credentials.
     * @return Optional<User> containing the authenticated user if credentials are valid, otherwise empty.
     */
    public Optional<User> loginUser(LoginRequest loginRequest) {
        Optional<User> userOptional = userRepository.findByEmail(loginRequest.getEmail());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Check if the provided password matches the stored hashed password
            if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                return Optional.of(user); // Passwords match
            }
        }
        return Optional.empty(); // User not found or password doesn't match
    }

    // --- JWT Based Login (Example if you add JWT later) ---
    /*
    public String authenticateAndGenerateToken(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        // UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        // List<String> roles = userDetails.getAuthorities().stream()
        // .map(item -> item.getAuthority())
        // .collect(Collectors.toList());

        return jwt; // Or return a more complex AuthResponse DTO
    }
    */
}