package movies.select.com.br.backend.application.service.user;

import lombok.RequiredArgsConstructor;
import movies.select.com.br.backend.adapters.outbound.repository.user.UserRepositoryImpl;
import movies.select.com.br.backend.application.usecase.user.FindUserUseCase;
import movies.select.com.br.backend.domain.exception.UserNotFoundException;
import movies.select.com.br.backend.domain.user.User;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindUserServiceImpl implements FindUserUseCase {

    private final UserRepositoryImpl userRepository;
    private final JwtDecoder jwtDecoder;

    @Override
    public User byEmail(String email) {
        Optional<User> user = this.userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }
        return user.get();
    }

    @Override
    public User byId(UUID id) {
        Optional<User> user = this.userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }
        return user.get();
    }

    @Override
    public User byToken(String token) {
        return this.byId(UUID.fromString(jwtDecoder.decode(token).getClaim("id")));
    }
}