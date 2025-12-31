package movies.select.com.br.backend.adapters.inbound.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import movies.select.com.br.backend.application.service.user.CreateUserServiceImpl;
import movies.select.com.br.backend.application.service.user.DetailUserServiceImpl;
import movies.select.com.br.backend.application.service.user.ListUsersServiceImpl;
import movies.select.com.br.backend.application.usecase.user.UserUseCase;
import movies.select.com.br.backend.domain.user.UserDetailResponse;
import movies.select.com.br.backend.domain.user.UserRequest;
import movies.select.com.br.backend.domain.user.UserResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController implements UserUseCase {

    private final CreateUserServiceImpl createUserService;
    private final ListUsersServiceImpl listUsersService;
    private final DetailUserServiceImpl detailUserService;

    @PostMapping
    @ResponseStatus(CREATED)
    @Override
    public UserResponse create(@Valid @RequestBody UserRequest user, HttpServletResponse response) {
        return createUserService.create(user, response);
    }

    @GetMapping
    @ResponseStatus(OK)
    @Override
    public List<UserResponse> list() {
        return listUsersService.list();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    @Override
    public UserDetailResponse detail(@PathVariable UUID id) {
        return detailUserService.detail(id);
    }
}
