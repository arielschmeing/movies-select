package movies.select.com.br.backend.application.usecase.user;

import jakarta.servlet.http.HttpServletResponse;
import movies.select.com.br.backend.domain.user.UserRequest;
import movies.select.com.br.backend.domain.user.UserResponse;

public interface CreateUserUseCase {
    UserResponse create(UserRequest request, HttpServletResponse response);
}
