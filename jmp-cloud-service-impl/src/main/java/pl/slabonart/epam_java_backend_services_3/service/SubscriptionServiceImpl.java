package pl.slabonart.epam_java_backend_services_3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.slabonart.epam_java_backend_services_3.repository.SubscriptionRepository;
import pl.slabonart.epam_java_backend_services_3.domain.Subscription;
import pl.slabonart.epam_java_backend_services_3.domain.User;
import pl.slabonart.epam_java_backend_services_3.dto.SubscriptionRequestDto;
import pl.slabonart.epam_java_backend_services_3.dto.SubscriptionResponseDto;
import pl.slabonart.epam_java_backend_services_3.exceptions.SubscriptionNotFoundException;
import pl.slabonart.epam_java_backend_services_3.exceptions.UserNotFoundException;
import pl.slabonart.epam_java_backend_services_3.mappers.SubscriptionDtoRequestMapper;
import pl.slabonart.epam_java_backend_services_3.mappers.SubscriptionDtoResponseMapper;

import pl.slabonart.epam_java_backend_services_3.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private SubscriptionRepository repository;
    private UserRepository userRepository;
    private SubscriptionDtoResponseMapper responseMapper;
    private SubscriptionDtoRequestMapper requestMapper;

    @Override
    public List<SubscriptionResponseDto> getAllSubscriptions() {
        List<Subscription> subscriptions = (List<Subscription>) repository.findAll();
        return responseMapper.toResponseList(subscriptions);

    }

    @Override
    public SubscriptionResponseDto getSubscription(Long id) {
        Subscription subscription = repository.findById(id).orElseThrow(() -> new SubscriptionNotFoundException(id));
        return responseMapper.toResponseDto(subscription);
    }

    @Override
    public SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequestDto) {

        User user = userRepository.findById(subscriptionRequestDto.getUserId())
                .orElseThrow(() -> new UserNotFoundException(subscriptionRequestDto.getUserId()));

        Subscription subscription = requestMapper.toSubscription(subscriptionRequestDto);
        subscription.setUser(user);

        Subscription saved = repository.save(subscription);
        return responseMapper.toResponseDto(saved);
    }

    @Override
    public SubscriptionResponseDto updateSubscription(Long id, SubscriptionRequestDto subscriptionRequestDto) {

        Subscription subscription = repository.findById(id).orElseThrow(() -> new SubscriptionNotFoundException(id));

        User user = userRepository.findById(subscriptionRequestDto.getUserId()).
                orElseThrow(() -> new UserNotFoundException(subscriptionRequestDto.getUserId()));

        subscription.setUser(user);
        subscription.setStartDate(subscriptionRequestDto.getStartDate());

        Subscription saved = repository.save(subscription);
        return responseMapper.toResponseDto(saved);
    }

    @Override
    public void deleteSubscription(Long subscriptionId) {
        Subscription subscription = repository.findById(subscriptionId)
                .orElseThrow(() -> new SubscriptionNotFoundException(subscriptionId));
        repository.delete(subscription);
    }
}
