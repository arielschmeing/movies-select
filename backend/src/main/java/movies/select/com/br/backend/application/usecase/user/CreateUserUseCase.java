package movies.select.com.br.backend.application.usecase.user;

import jakarta.servlet.http.HttpServletResponse;
import movies.select.com.br.backend.domain.user.UserDetailResponse;
import movies.select.com.br.backend.domain.user.UserRequest;

public interface CreateUserUseCase {
    UserDetailResponse create(UserRequest request, HttpServletResponse response);
}
