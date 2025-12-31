package movies.select.com.br.backend.application.usecase.user;

import movies.select.com.br.backend.domain.user.UserResponse;

import java.util.List;

public interface ListUsersUseCase {
    List<UserResponse> list();
}

