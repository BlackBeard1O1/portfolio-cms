package org.mulu.pcms.dto.request.authRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthLoginRequestDTO {
    private String email;
    private String password;
}
