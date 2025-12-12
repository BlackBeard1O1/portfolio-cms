package org.mulu.pcms.mapper;

import org.mulu.pcms.dto.request.UserRequestDTO;
import org.mulu.pcms.dto.response.UserResponseDTO;
import org.mulu.pcms.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequestDTO dto) {
        if (dto == null)
            return null;
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setFirstName(dto.getFirstname());
        user.setLastName(dto.getLastname());
        user.setEmail(dto.getEmail());
        user.setRole("USER"); // Default role for new signup
        return user;
    }

    // Partial update (PATCH)
    public User updateEntityFromDto(UserRequestDTO dto, User user) {
        if (dto == null || user == null) return user;
        if (dto.getUsername() != null)
            user.setUsername(dto.getUsername());
        if (dto.getFirstname() != null)
            user.setFirstName(dto.getFirstname());
        if (dto.getFirstname() != null)
            user.setLastName(dto.getLastname());
        if (dto.getEmail() != null)
            user.setEmail(dto.getEmail());

        return user;
    }

    
    public UserResponseDTO toDto(User entity) {
        if (entity == null)
            return null;
        return new UserResponseDTO(
                entity.getId(),
                entity.getUsername(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getRole(),
                entity.getDateCreated());
    }
}
