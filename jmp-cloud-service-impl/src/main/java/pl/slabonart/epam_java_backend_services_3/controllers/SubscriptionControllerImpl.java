package pl.slabonart.epam_java_backend_services_3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.slabonart.epam_java_backend_services_3.dto.SubscriptionRequestDto;
import pl.slabonart.epam_java_backend_services_3.dto.SubscriptionResponseDto;
import pl.slabonart.epam_java_backend_services_3.exceptions.SubscriptionNotFoundException;
import pl.slabonart.epam_java_backend_services_3.exceptions.UserNotFoundException;
import pl.slabonart.epam_java_backend_services_3.service.SubscriptionService;

import java.util.List;

@RestController
@AllArgsConstructor
public class SubscriptionControllerImpl implements SubscriptionController {

    private  SubscriptionService subscriptionService;

    @Override
    public ResponseEntity<SubscriptionResponseDto> createSubscription(@RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        return ResponseEntity.ok(subscriptionService.createSubscription(subscriptionRequestDto));
    }

    @Override
    public ResponseEntity<SubscriptionResponseDto> updateSubscription(@PathVariable Long id, @RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        return ResponseEntity.ok(subscriptionService.updateSubscription(id, subscriptionRequestDto));
    }

    @Override
    public void deleteSubscription(@PathVariable Long id) {
        subscriptionService.deleteSubscription(id);
    }

    @Override
    public ResponseEntity<SubscriptionResponseDto> getSubscription(@PathVariable Long id) {
        return ResponseEntity.ok(subscriptionService.getSubscription(id));
    }

    @Override
    public ResponseEntity<List<SubscriptionResponseDto>> getAllSubscriptions() {

        List<SubscriptionResponseDto> subscriptions = subscriptionService.getAllSubscriptions();
        if (subscriptions != null && !subscriptions.isEmpty()) {
            return ResponseEntity.ok(subscriptions);
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

    @ExceptionHandler(SubscriptionNotFoundException.class)
    public ResponseEntity handleSubscriptionNotFoundException(SubscriptionNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }
}
