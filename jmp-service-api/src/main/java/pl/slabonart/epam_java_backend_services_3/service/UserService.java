package pl.slabonart.epam_java_backend_services_3.service;

import pl.slabonart.epam_java_backend_services_3.dto.UserRequestDto;
import pl.slabonart.epam_java_backend_services_3.dto.UserResponseDto;

import java.util.List;


public interface UserService {

    List<UserResponseDto> getAllUsers();

    UserResponseDto getUser(Long userId);

    UserResponseDto createUser(UserRequestDto userRequestDto);

    UserResponseDto updateUser(Long userId, UserRequestDto userRequestDto);

    void deleteUser(Long userId);
}
