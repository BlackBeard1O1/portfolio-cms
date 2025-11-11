package org.mulu.pcms.mapper;

import java.time.LocalDate;
import org.mulu.pcms.dto.request.UserRequestDTO;
import org.mulu.pcms.dto.response.UserResponseDTO;
import org.mulu.pcms.entity.User;
import org.springframework.stereotype.Component;

/**
 * Converts between User entity and DTOs.
 */
@Component
public class UserMapper {

    // Convert DTO → Entity for CREATE
    public User toEntity(UserRequestDTO dto) {
        if (dto == null)
            return null;
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setFirstName(dto.getFirstname());
        user.setLastName(dto.getFirstname());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole("USER"); // Default role for new signup
        user.setDateCreated(LocalDate.now());
        return user;
    }

    public User toEntity(UserResponseDTO dto) {
        if (dto == null)
            return null;
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getFirstName());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole()); // Default role for new signup
        return user;
    }

    // Partial update (PATCH)
    public void updateEntityFromDto(UserRequestDTO dto, User user) {
        if (dto == null || user == null)
            return;
        if (dto.getUsername() != null)
            user.setUsername(dto.getUsername());
        if (dto.getFirstname() != null)
            user.setFirstName(dto.getFirstname());
        if (dto.getFirstname() != null)
            user.setLastName(dto.getFirstname());
        if (dto.getEmail() != null)
            user.setEmail(dto.getEmail());
        if (dto.getPassword() != null)
            user.setPassword(dto.getPassword());
        // role intentionally not updated from DTO
    }

    // Convert Entity → DTO
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
