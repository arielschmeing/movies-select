package movies.select.com.br.backend.adapters.inbound.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import movies.select.com.br.backend.application.service.auth.LoginServiceImpl;
import movies.select.com.br.backend.application.usecase.auth.AuthUseCase;
import movies.select.com.br.backend.domain.auth.LoginRequest;
import movies.select.com.br.backend.domain.user.UserResponse;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController implements AuthUseCase {

    private final LoginServiceImpl loginService;

    @PostMapping("/login")
    @ResponseStatus(OK)
    @Override
    public UserResponse login(@Valid @RequestBody LoginRequest request, HttpServletResponse response) {
        return this.loginService.login(request, response);
    }
}
