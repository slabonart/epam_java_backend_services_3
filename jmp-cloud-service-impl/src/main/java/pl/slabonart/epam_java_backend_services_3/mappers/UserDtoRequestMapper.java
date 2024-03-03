package pl.slabonart.epam_java_backend_services_3.mappers;

import org.mapstruct.Mapper;
import pl.slabonart.epam_java_backend_services_3.domain.User;
import pl.slabonart.epam_java_backend_services_3.dto.UserRequestDto;

@Mapper(componentModel = "spring")
public interface UserDtoRequestMapper {

    User toUser(UserRequestDto responseDto);
    UserRequestDto toRequestDto(User user);

}
