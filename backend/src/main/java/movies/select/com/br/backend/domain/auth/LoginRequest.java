package movies.select.com.br.backend.domain.auth;

import movies.select.com.br.backend.utils.annotation.EmailValidation;
import movies.select.com.br.backend.utils.annotation.PasswordValidation;

public record LoginRequest(
        @EmailValidation
        String email,

        @PasswordValidation
        String password
) {}