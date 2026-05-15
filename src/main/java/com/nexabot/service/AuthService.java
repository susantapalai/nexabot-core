package com.nexabot.service;

import com.nexabot.dto.AuthResponse;
import com.nexabot.dto.LoginRequest;
import com.nexabot.dto.RegisterRequest;
import com.nexabot.model.User;
import com.nexabot.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       JwtService jwtService,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponse register(RegisterRequest request) {
        AuthResponse response = new AuthResponse();

        if (userRepository.existsByEmail(request.getEmail())) {
            response.setSuccess(false);
            response.setError("Email already exists");
            return response;
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setBusinessId(request.getBusinessId());
        userRepository.save(user);

        String token = jwtService.generateToken(
                request.getEmail(),
                request.getBusinessId()
        );

        response.setToken(token);
        response.setName(request.getName());
        response.setEmail(request.getEmail());
        response.setBusinessId(request.getBusinessId());
        response.setSuccess(true);
        return response;
    }

    public AuthResponse login(LoginRequest request) {
        AuthResponse response = new AuthResponse();

        User user = userRepository.findByEmail(request.getEmail())
                .orElse(null);

        if (user == null || !passwordEncoder.matches(
                request.getPassword(), user.getPassword())) {
            response.setSuccess(false);
            response.setError("Invalid email or password");
            return response;
        }

        String token = jwtService.generateToken(
                user.getEmail(),
                user.getBusinessId()
        );

        response.setToken(token);
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setBusinessId(user.getBusinessId());
        response.setSuccess(true);
        return response;
    }
}