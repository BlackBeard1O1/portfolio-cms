package org.mulu.pcms.dto.request.authRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRegisterRequestDTO {
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
