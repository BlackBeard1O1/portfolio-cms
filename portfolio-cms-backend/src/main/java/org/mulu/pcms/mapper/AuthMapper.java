package org.mulu.pcms.mapper;

import java.time.LocalDate;

import org.mulu.pcms.dto.request.authRequest.AuthRegisterRequestDTO;
import org.mulu.pcms.dto.response.authResponse.AuthResponseDTO;
import org.mulu.pcms.entity.User;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper {

    public User toEntity(AuthRegisterRequestDTO request) {
        if(request == null) 
            return null;

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstname());
        user.setLastName(request.getLastname());
        user.setRole("USER");
        user.setDateCreated(LocalDate.now());

        return user;
    }

    public AuthResponseDTO toDto(User saved) {
        if(saved == null)
            return null;

        AuthResponseDTO response = new AuthResponseDTO();
        response.setId(saved.getId());
        response.setUsername(saved.getUsername());
        response.setEmail(saved.getEmail());
        response.setFirstName(saved.getFirstName());
        response.setLastName(saved.getLastName());
        response.setRole(saved.getRole());
        response.setDateCreated(saved.getDateCreated());

        return response;
    }
    
}
