package org.mulu.pcms.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.mulu.pcms.dto.request.UserRequestDTO;
import org.mulu.pcms.dto.response.UserResponseDTO;
import org.mulu.pcms.entity.User;
import org.mulu.pcms.mapper.UserMapper;
import org.mulu.pcms.repository.UserRepository;
import org.mulu.pcms.service.UserService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return userMapper.toDto(user);
    }

    @Override
    public UserResponseDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        return userMapper.toDto(user);
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {

        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        User updatedUser = userMapper.updateEntityFromDto(dto, existing);
        User saved = userRepository.save(updatedUser);
        return userMapper.toDto(saved);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}
