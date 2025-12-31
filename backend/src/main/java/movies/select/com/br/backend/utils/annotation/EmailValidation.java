package movies.select.com.br.backend.utils.annotation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static movies.select.com.br.backend.utils.annotation.EmailValidation.MAX_EMAIL;
import static movies.select.com.br.backend.utils.annotation.EmailValidation.MIN_EMAIL;

@Documented
@Target(FIELD)
@Email(message = "Invalid Email.")
@NotNull(message = "Email cannot be null.")
@Retention(RUNTIME)
@Size(
        max = MAX_EMAIL,
        min = MIN_EMAIL,
        message = "The Email must contain between " + MAX_EMAIL + " and " + MIN_EMAIL + " characters.")
public @interface EmailValidation {
    int MAX_EMAIL = 256;
    int MIN_EMAIL = 8;
}

