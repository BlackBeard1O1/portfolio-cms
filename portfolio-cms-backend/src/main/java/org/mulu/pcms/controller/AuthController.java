package org.mulu.pcms.controller;

import org.mulu.pcms.dto.request.authRequest.AuthLoginRequestDTO;
import org.mulu.pcms.dto.request.authRequest.AuthRefreshTokenRequestDTO;
import org.mulu.pcms.dto.request.authRequest.AuthRegisterRequestDTO;
import org.mulu.pcms.dto.response.authResponse.AuthRefreshTokenResponseDTO;
import org.mulu.pcms.dto.response.authResponse.AuthResponseDTO;
import org.mulu.pcms.dto.response.authResponse.LoginResponseDTO;
import org.mulu.pcms.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody AuthRegisterRequestDTO request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody AuthLoginRequestDTO request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthRefreshTokenResponseDTO> refresh(@RequestBody AuthRefreshTokenRequestDTO request) {
        return ResponseEntity.ok(authService.refreshToken(request));
    }
}