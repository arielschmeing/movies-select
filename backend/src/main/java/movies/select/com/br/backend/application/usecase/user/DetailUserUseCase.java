package movies.select.com.br.backend.application.usecase.user;

import movies.select.com.br.backend.domain.user.UserResponse;

import java.util.UUID;

public interface DetailUserUseCase {
    UserResponse detail(UUID id);
}
