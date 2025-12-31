package movies.select.com.br.backend.domain.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class UserNotFoundException extends ApplicationException {

    public UserNotFoundException() {
        super(
                "user-not-found",
                "User does not found.",
                NOT_FOUND
        );
    }
}
