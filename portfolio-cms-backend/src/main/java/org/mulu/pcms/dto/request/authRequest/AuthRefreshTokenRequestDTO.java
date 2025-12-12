package org.mulu.pcms.dto.request.authRequest;

import lombok.Data;

@Data
public class AuthRefreshTokenRequestDTO {
    private String refreshToken;
}
