package movies.select.com.br.backend.application.service.user;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import movies.select.com.br.backend.adapters.outbound.repository.user.UserRepositoryImpl;
import movies.select.com.br.backend.application.service.auth.LoginServiceImpl;
import movies.select.com.br.backend.application.usecase.user.CreateUserUseCase;
import movies.select.com.br.backend.domain.auth.LoginRequest;
import movies.select.com.br.backend.domain.user.User;
import movies.select.com.br.backend.domain.user.UserDetailResponse;
import movies.select.com.br.backend.domain.user.UserRequest;
import movies.select.com.br.backend.utils.mapper.UserMapper;
import movies.select.com.br.backend.utils.validation.user.UserFoundValidator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
public class CreateUserServiceImpl implements CreateUserUseCase {

    private final UserRepositoryImpl userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserFoundValidator userFoundValidator;
    private final LoginServiceImpl loginService;

    @Transactional
    @Override
    public UserDetailResponse create(UserRequest request, HttpServletResponse response) {

        userFoundValidator.validate(request.email());

        User user = userMapper.requestToDomain(request);
        user.setActivated(true);
        user.setCreatedAt(now());
        user.setUpdatedAt(now());
        user.setPassword(passwordEncoder.encode(request.password()));

        this.userRepository.save(user);

        return loginService.login(
                new LoginRequest(request.email(), request.password()),
                response);
    }
}