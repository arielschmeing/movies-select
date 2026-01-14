package movies.select.com.br.backend.application.service.auth;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import movies.select.com.br.backend.application.service.user.DetailUserServiceImpl;
import movies.select.com.br.backend.application.service.user.FindUserServiceImpl;
import movies.select.com.br.backend.application.usecase.auth.LoginUseCase;
import movies.select.com.br.backend.domain.auth.LoginRequest;
import movies.select.com.br.backend.domain.user.User;
import movies.select.com.br.backend.domain.user.UserDetailResponse;
import org.springframework.http.ResponseCookie;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpHeaders.SET_COOKIE;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginUseCase {

    private static final Long expiresIn = 86400L;

    private final FindUserServiceImpl findUserService;
    private final JwtEncoder jwtEncoder;
    private final PasswordEncoder passwordEncoder;
    private final DetailUserServiceImpl detailUserService;

    @Transactional
    @Override
    public UserDetailResponse login(LoginRequest request, HttpServletResponse response) {

        User user = this.findUserService.byEmail(request.email());

        if (!this.passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new ResponseStatusException(UNAUTHORIZED, "User or Password invalid.");
        }

        JwtClaimsSet jwt = this.jwtClaim(user, expiresIn);
        String token = jwtEncoder.encode(JwtEncoderParameters.from(jwt)).getTokenValue();

        ResponseCookie cookie = ResponseCookie.from("ACCESS_TOKEN", token)
                .httpOnly(true)
                .secure(false)
                .sameSite("LAX")
                .path("/")
                .maxAge(expiresIn.intValue())
                .build();

        response.addHeader(SET_COOKIE, cookie.toString());

        return this.detailUserService.detail(user.getId());
    }
}