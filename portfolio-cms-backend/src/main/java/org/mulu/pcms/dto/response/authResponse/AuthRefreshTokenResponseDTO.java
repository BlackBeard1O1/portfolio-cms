package org.mulu.pcms.dto.response.authResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthRefreshTokenResponseDTO {
    private String accessToken;
    private String refreshToken;
    private String message;
}
