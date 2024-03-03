package pl.slabonart.epam_java_backend_services_3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.slabonart.epam_java_backend_services_3.dto.UserRequestDto;
import pl.slabonart.epam_java_backend_services_3.dto.UserResponseDto;
import pl.slabonart.epam_java_backend_services_3.exceptions.UserNotFoundException;
import pl.slabonart.epam_java_backend_services_3.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserControllerImpl implements UserController {

    private UserService userService;

    @Override
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok(userService.createUser(userRequestDto));
    }

    @Override
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long userId, @RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok(userService.updateUser(userId, userRequestDto));
    }

    @Override
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

    @Override
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @Override
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {

        List<UserResponseDto> userList = userService.getAllUsers();
        if (userList != null && !userList.isEmpty()) {
            return ResponseEntity.ok(userList);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity handleUserNotFoundException(UserNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }
}
