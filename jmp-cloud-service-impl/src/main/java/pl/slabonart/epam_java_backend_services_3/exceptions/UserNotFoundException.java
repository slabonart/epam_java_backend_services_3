package pl.slabonart.epam_java_backend_services_3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    private static final String MESSAGE = "User with id = %d not found.";

    public UserNotFoundException(Long userId) {
        super(String.format(MESSAGE, userId));
    }
}
