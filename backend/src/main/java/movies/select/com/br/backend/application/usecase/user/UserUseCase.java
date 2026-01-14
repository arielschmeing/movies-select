package movies.select.com.br.backend.application.usecase.user;

import jakarta.servlet.http.HttpServletResponse;
import movies.select.com.br.backend.domain.user.UserDetailResponse;
import movies.select.com.br.backend.domain.user.UserRequest;
import movies.select.com.br.backend.domain.user.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserUseCase {
    UserDetailResponse create(UserRequest user, HttpServletResponse response);
    List<UserResponse> list();
    UserDetailResponse detail(UUID id);
}
