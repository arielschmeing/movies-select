package movies.select.com.br.backend.application.service.user;

import lombok.RequiredArgsConstructor;
import movies.select.com.br.backend.application.service.party.ListUserPartiesServiceImpl;
import movies.select.com.br.backend.application.usecase.user.DetailUserUseCase;
import movies.select.com.br.backend.domain.user.User;
import movies.select.com.br.backend.domain.user.UserDetailResponse;
import movies.select.com.br.backend.utils.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DetailUserServiceImpl implements DetailUserUseCase {

    private final UserMapper userMapper;
    private final FindUserServiceImpl findUserService;
    private final ListUserPartiesServiceImpl listUserPartiesService;

    @Transactional
    @Override
    public UserDetailResponse detail(UUID id) {
        User user = findUserService.byId(id);
        UserDetailResponse response = this.userMapper.domainToDetailedResponse(user);
        response.setParties(this.listUserPartiesService.list(user.getId()));
        return response;
    }
}