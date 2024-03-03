package pl.slabonart.epam_java_backend_services_3.service;

import pl.slabonart.epam_java_backend_services_3.dto.SubscriptionRequestDto;
import pl.slabonart.epam_java_backend_services_3.dto.SubscriptionResponseDto;

import java.util.List;

public interface SubscriptionService {

    List<SubscriptionResponseDto> getAllSubscriptions();

    SubscriptionResponseDto getSubscription(Long userId);

    SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequestDto);

    SubscriptionResponseDto updateSubscription(Long id, SubscriptionRequestDto subscriptionRequestDto);

    void deleteSubscription(Long subscriptionId);
}
