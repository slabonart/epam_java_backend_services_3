package pl.slabonart.epam_java_backend_services_3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SubscriptionNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Subscription with id = %d not found.";

    public SubscriptionNotFoundException(Long id) {
        super(String.format(MESSAGE, id));
    }
}
