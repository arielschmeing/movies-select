package movies.select.com.br.backend.adapters.outbound.repository.user;

import lombok.RequiredArgsConstructor;
import movies.select.com.br.backend.adapters.outbound.entity.JpaUserEntity;
import movies.select.com.br.backend.domain.user.User;
import movies.select.com.br.backend.domain.user.UserRepository;
import movies.select.com.br.backend.utils.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserMapper userMapper;
    private final JpaUserRepository jpaUserRepository;

    @Override
    public void save(User user) {
        JpaUserEntity userEntity = new JpaUserEntity(user);
        this.jpaUserRepository.save(userEntity);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return this.jpaUserRepository.findById(id).map(userMapper::entityToDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return this.jpaUserRepository.findByEmail(email).map(userMapper::entityToDomain);
    }

    @Override
    public List<User> findAll() {
        List<JpaUserEntity> usersEntities = this.jpaUserRepository.findAll();
        return usersEntities
                .stream()
                .map(userMapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        this.jpaUserRepository.deleteById(id);
    }
}
