package pl.slabonart.epam_java_backend_services_3.mappers;

import org.mapstruct.Mapper;
import pl.slabonart.epam_java_backend_services_3.domain.Subscription;
import pl.slabonart.epam_java_backend_services_3.dto.SubscriptionRequestDto;

@Mapper(componentModel = "spring")
public interface SubscriptionDtoRequestMapper {

    Subscription toSubscription(SubscriptionRequestDto requestDto);
    SubscriptionRequestDto toRequestDto(Subscription subscription);

}
