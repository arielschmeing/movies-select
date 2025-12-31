package movies.select.com.br.backend.domain.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import movies.select.com.br.backend.utils.annotation.EmailValidation;
import movies.select.com.br.backend.utils.annotation.PasswordValidation;

public record UserRequest(
        @NotBlank(message = "Name cannot be left blank.")
        @Size(
                max = MAX_NAME,
                min = MIN_NAME,
                message = "The Name must contain between " + MAX_NAME + " and " + MIN_NAME + " characters.")
        String name,

        @EmailValidation
        String email,

        @PasswordValidation
        String password
) {
    private static final int MAX_NAME = 128;
    private static final int MIN_NAME = 3;
}

