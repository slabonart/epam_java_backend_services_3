package pl.slabonart.epam_java_backend_services_3.mappers;

import org.mapstruct.Mapper;
import pl.slabonart.epam_java_backend_services_3.domain.User;
import pl.slabonart.epam_java_backend_services_3.dto.UserResponseDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDtoResponseMapper {

    User toUser(UserResponseDto responseDto);
    UserResponseDto toResponseDto(User user);

    List<UserResponseDto> toResponseList(List<User> users);
}
