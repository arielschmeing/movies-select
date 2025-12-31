package movies.select.com.br.backend.application.usecase.user;

import movies.select.com.br.backend.domain.user.User;

import java.util.UUID;

public interface FindUserUseCase {
    User byEmail(String email);
    User byId(UUID id);
    User byToken(String token);
}
