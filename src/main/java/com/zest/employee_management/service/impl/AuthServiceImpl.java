package com.zest.employee_management.service.impl;

import com.zest.employee_management.dto.AuthResponse;
import com.zest.employee_management.dto.LoginRequest;
import com.zest.employee_management.dto.RegisterRequest;
import com.zest.employee_management.entity.User.User;
import com.zest.employee_management.repository.User.UserRepository;
import com.zest.employee_management.security.JwtService;
import com.zest.employee_management.service.Auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.
        AuthenticationManager;
import org.springframework.security.authentication.
        UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.
        PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse register(RegisterRequest request) {

        if (userRepository.existsByUserName(
                request.getUserName())) {

            throw new RuntimeException(
                    "Username already exists"
            );
        }

        if (userRepository.existsByEmail(
                request.getEmail())) {

            throw new RuntimeException(
                    "Email already exists"
            );
        }

        User user = User.builder()
                .userName(request.getUserName())
                .email(request.getEmail())
                .password(
                        passwordEncoder.encode(
                                request.getPassword()
                        )
                )
                .build();

        userRepository.save(user);

        String jwtToken = jwtService.generateToken(
                org.springframework.security.core.userdetails.
                        User.builder()
                        .username(user.getUserName())
                        .password(user.getPassword())
                        .build()
        );

        return new AuthResponse(jwtToken);
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUserName(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByUserName(
                        request.getUserName())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        String jwtToken = jwtService.generateToken(
                org.springframework.security.core.userdetails.
                        User.builder()
                        .username(user.getUserName())
                        .password(user.getPassword())
                        .build()
        );

        return new AuthResponse(jwtToken);
    }
}