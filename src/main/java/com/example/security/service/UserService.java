package com.example.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.security.model.Users;
import com.example.security.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;

    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    public Users register(String username, String password) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Please enter a username");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Please enter a password");
        }

        // // Check if user already exists
        // if (userRepository.findByUsername(username) != null) {
        // throw new IllegalArgumentException("Username already taken");
        // }

        Users user = new Users();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password)); // Encode password before saving
        return userRepository.save(user);
    }

    public String verify(Users user) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated()) {
            // return "Success";
            return jwtService.generateToken(user.getUsername());
        }
        return "fail";
    }
}
