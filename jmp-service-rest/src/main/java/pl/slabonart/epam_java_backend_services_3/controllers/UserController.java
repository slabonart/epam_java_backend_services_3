package pl.slabonart.epam_java_backend_services_3.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.slabonart.epam_java_backend_services_3.dto.UserRequestDto;
import pl.slabonart.epam_java_backend_services_3.dto.UserResponseDto;

import java.util.List;

@Api(value = "User Controller", description = "Rest API related to User entity", tags = "User API")
public interface UserController {

    @PostMapping(
            path = "/users",
            produces = "application/json",
            consumes = "application/json"
    )
    @ApiOperation(value = "Allows to create new user resource")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess | OK", response = UserResponseDto.class) })
    ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto);

    @PutMapping("/users/{userId}")
    @ApiOperation(value = "Allows to update existing user resource", response = UserResponseDto.class)
    @ApiResponses(value = {
                    @ApiResponse(code = 200, message = ""),
                    @ApiResponse(code = 404, message = "User not found!!!")
            }
    )
    ResponseEntity<UserResponseDto> updateUser(@PathVariable Long userId, @RequestBody UserRequestDto userRequestDto);

    @DeleteMapping("/users/{userId}")
    @ApiOperation(value = "Delete existing user resource")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess | User deleted"),
            @ApiResponse(code = 400, message = "User not found!!!") })
    void deleteUser(@PathVariable Long userId);

    @GetMapping(value = "/users/{id}", produces = "application/json")
    @ApiOperation(value = "Get existing user resource")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess | OK", response = UserResponseDto.class),
            @ApiResponse(code = 404, message = "User not found!!!") })
    ResponseEntity<UserResponseDto> getUser(@PathVariable Long userId);

    @GetMapping(value = "/users", produces = "application/json")
    @ApiOperation(value = "Get all existing users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess | OK", response = UserResponseDto.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "not found!!!") })
    ResponseEntity<List<UserResponseDto>> getAllUsers();
}
