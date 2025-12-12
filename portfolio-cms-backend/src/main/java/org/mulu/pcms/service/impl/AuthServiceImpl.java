package org.mulu.pcms.service.impl;

import org.mulu.pcms.config.JwtUtil;
import org.mulu.pcms.dto.request.authRequest.AuthLoginRequestDTO;
import org.mulu.pcms.dto.request.authRequest.AuthRefreshTokenRequestDTO;
import org.mulu.pcms.dto.request.authRequest.AuthRegisterRequestDTO;
import org.mulu.pcms.dto.response.authResponse.AuthRefreshTokenResponseDTO;
import org.mulu.pcms.dto.response.authResponse.AuthResponseDTO;
import org.mulu.pcms.dto.response.authResponse.LoginResponseDTO;
import org.mulu.pcms.entity.User;
import org.mulu.pcms.mapper.AuthMapper;
import org.mulu.pcms.repository.AuthRepository;
import org.mulu.pcms.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final AuthRepository authRepository;
    private final AuthMapper authMapper;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;

    @Override
    public AuthResponseDTO register(AuthRegisterRequestDTO request) {
        if (authRepository.findByEmail(request.getEmail()) != null) {
            throw new RuntimeException("User already exists");
        }

        User user = authMapper.toEntity(request);

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User saved = authRepository.save(user);
        return authMapper.toDto(saved);
    }

    @Override
    public LoginResponseDTO login(AuthLoginRequestDTO request) {
        // Authenticate user credentials
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));

        // If successful, generate JWT
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(request.getEmail());
        String token = jwtUtil.generateToken(userDetails.getUsername());

        return new LoginResponseDTO(token, "Login successful");
    }

    @Override
    public AuthRefreshTokenResponseDTO refreshToken(AuthRefreshTokenRequestDTO request) {
        String refreshToken = request.getRefreshToken();

        if (!jwtUtil.validateToken(refreshToken)) {
            throw new RuntimeException("Invalid or expired refresh token");
        }

        // Extract username (email) from refresh token
        String email = jwtUtil.extractUsername(refreshToken);
        User user = authRepository.findByEmail(email);
                // .orElseThrow(() -> new RuntimeException("User not found"));

        // Generate a new access token
        String newAccessToken = jwtUtil.generateToken(user.getEmail());

        // Optionally generate a new refresh token too:
        String newRefreshToken = jwtUtil.generateRefreshToken(user.getEmail());

        return new AuthRefreshTokenResponseDTO(newAccessToken, newRefreshToken, "Token refreshed successfully");
    }

}
