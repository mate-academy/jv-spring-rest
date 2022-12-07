package mate.academy.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,
        reason = "Movie session not found!")
public class MovieSessionNotFoundException extends RuntimeException {
    public MovieSessionNotFoundException(String message,
                                         Throwable cause) {
        super(message, cause);
    }
}
