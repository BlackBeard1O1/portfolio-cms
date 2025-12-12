package org.mulu.pcms.service;

import org.mulu.pcms.dto.request.authRequest.AuthLoginRequestDTO;
import org.mulu.pcms.dto.request.authRequest.AuthRefreshTokenRequestDTO;
import org.mulu.pcms.dto.request.authRequest.AuthRegisterRequestDTO;
import org.mulu.pcms.dto.response.authResponse.AuthRefreshTokenResponseDTO;
import org.mulu.pcms.dto.response.authResponse.AuthResponseDTO;
import org.mulu.pcms.dto.response.authResponse.LoginResponseDTO;

public interface AuthService {

    AuthResponseDTO register(AuthRegisterRequestDTO request);

    LoginResponseDTO login(AuthLoginRequestDTO request);

    AuthRefreshTokenResponseDTO refreshToken(AuthRefreshTokenRequestDTO request);

}
