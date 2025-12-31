package movies.select.com.br.backend.domain.exception;

import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class UserAccessDeniedException extends ApplicationException {

    public UserAccessDeniedException(UUID id) {
        super(
                "user-access-denied",
                String.format("User=%s does not have permission for this action.", id),
                NOT_FOUND
        );
    }
}
