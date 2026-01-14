package movies.select.com.br.backend.application.usecase.auth;

import jakarta.servlet.http.HttpServletResponse;
import movies.select.com.br.backend.domain.auth.LoginRequest;
import movies.select.com.br.backend.domain.user.User;
import movies.select.com.br.backend.domain.user.UserDetailResponse;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;

import java.time.Instant;

public interface LoginUseCase {
    UserDetailResponse login(LoginRequest request, HttpServletResponse response);

    default JwtClaimsSet jwtClaim(User user, long expiresIn) {
        return JwtClaimsSet.builder()
                .issuer("movies-select")
                .subject(user.getName())
                .expiresAt(Instant.now().plusSeconds(expiresIn))
                .claim("id", user.getId())
                .build();
    }
}