package movies.select.com.br.backend.application.service.user;

import lombok.RequiredArgsConstructor;
import movies.select.com.br.backend.adapters.outbound.repository.user.UserRepositoryImpl;
import movies.select.com.br.backend.application.usecase.user.ListUsersUseCase;
import movies.select.com.br.backend.domain.user.UserResponse;
import movies.select.com.br.backend.utils.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListUsersServiceImpl implements ListUsersUseCase {

    private final UserMapper userMapper;
    private final UserRepositoryImpl userRepository;

    @Transactional
    @Override
    public List<UserResponse> list() {
        return userRepository.findAll()
                .stream()
                .map(this.userMapper::domainToResponse)
                .collect(Collectors.toList());
    }
}

