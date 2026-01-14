package movies.select.com.br.backend.application.usecase.auth;

import jakarta.servlet.http.HttpServletResponse;
import movies.select.com.br.backend.domain.auth.LoginRequest;
import movies.select.com.br.backend.domain.user.UserDetailResponse;

public interface AuthUseCase {
    UserDetailResponse login(LoginRequest request, HttpServletResponse response);
}
