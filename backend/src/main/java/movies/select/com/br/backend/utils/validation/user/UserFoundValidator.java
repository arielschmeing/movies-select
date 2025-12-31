package movies.select.com.br.backend.utils.validation.user;

import lombok.RequiredArgsConstructor;
import movies.select.com.br.backend.adapters.outbound.repository.user.UserRepositoryImpl;
import movies.select.com.br.backend.domain.exception.ApplicationException;
import movies.select.com.br.backend.domain.user.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
@RequiredArgsConstructor
public class UserFoundValidator {

    private final UserRepositoryImpl userRepository;

    public void validate(String email) {

        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()) {
            throw new ApplicationException(
                    "user-exist",
                    String.format("User with email=%s already exists.", email),
                    BAD_REQUEST
            );
        }
    }
}
