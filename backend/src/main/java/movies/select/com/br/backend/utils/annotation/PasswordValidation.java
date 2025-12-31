package movies.select.com.br.backend.utils.annotation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static movies.select.com.br.backend.utils.annotation.PasswordValidation.MAX_PASSWORD;
import static movies.select.com.br.backend.utils.annotation.PasswordValidation.MIN_PASSWORD;

@Documented
@Target(FIELD)
@NotBlank(message = "Password cannot be left blank.")
@Retention(RUNTIME)
@Size(
        max = MAX_PASSWORD,
        min = MIN_PASSWORD,
        message = "The Password must contain between " + MAX_PASSWORD + " and " + MIN_PASSWORD + " characters.")
public @interface PasswordValidation {
    int MAX_PASSWORD = 256;
    int MIN_PASSWORD = 3;
}
