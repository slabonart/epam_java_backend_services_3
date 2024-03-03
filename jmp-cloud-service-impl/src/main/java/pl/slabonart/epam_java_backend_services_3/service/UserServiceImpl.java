package pl.slabonart.epam_java_backend_services_3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.slabonart.epam_java_backend_services_3.repository.SubscriptionRepository;
import pl.slabonart.epam_java_backend_services_3.domain.Subscription;
import pl.slabonart.epam_java_backend_services_3.domain.User;
import pl.slabonart.epam_java_backend_services_3.dto.UserRequestDto;
import pl.slabonart.epam_java_backend_services_3.dto.UserResponseDto;
import pl.slabonart.epam_java_backend_services_3.exceptions.UserNotFoundException;
import pl.slabonart.epam_java_backend_services_3.mappers.UserDtoRequestMapper;
import pl.slabonart.epam_java_backend_services_3.mappers.UserDtoResponseMapper;
import pl.slabonart.epam_java_backend_services_3.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository repository;
    private SubscriptionRepository subscriptionRepository;

    private UserDtoResponseMapper responseMapper;
    private UserDtoRequestMapper requestMapper;

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> users = (List<User>) repository.findAll();
        return responseMapper.toResponseList(users);
    }

    @Override
    public UserResponseDto getUser(Long userId) {
        User user = repository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        return responseMapper.toResponseDto(user);
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = repository.save(requestMapper.toUser(userRequestDto));
        return responseMapper.toResponseDto(user);
    }

    @Override
    public UserResponseDto updateUser(Long userId, UserRequestDto userRequestDto) {
        User user = repository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));

        user.setName(userRequestDto.getName());
        user.setSurname(userRequestDto.getSurname());
        user.setBirthday(userRequestDto.getBirthday());

        User saved = repository.save(user);
        return responseMapper.toResponseDto(saved);
    }

    @Override
    public void deleteUser(Long userId) {

        User user = repository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));

        ((List<Subscription>) subscriptionRepository.findAll()).stream()
                .filter(subscription -> user.equals(subscription.getUser()))
                        .findFirst().ifPresent(subscription -> subscriptionRepository.deleteById(subscription.getId()));
        repository.delete(user);
    }
}
