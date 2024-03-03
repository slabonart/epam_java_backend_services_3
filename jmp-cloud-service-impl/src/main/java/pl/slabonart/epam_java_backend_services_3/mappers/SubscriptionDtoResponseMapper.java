package pl.slabonart.epam_java_backend_services_3.mappers;

import org.mapstruct.Mapper;
import pl.slabonart.epam_java_backend_services_3.domain.Subscription;
import pl.slabonart.epam_java_backend_services_3.dto.SubscriptionResponseDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubscriptionDtoResponseMapper {

    Subscription toSubscription(SubscriptionResponseDto responseDto);
    SubscriptionResponseDto toResponseDto(Subscription subscription);

    List<SubscriptionResponseDto> toResponseList(List<Subscription> subscriptions);

}
