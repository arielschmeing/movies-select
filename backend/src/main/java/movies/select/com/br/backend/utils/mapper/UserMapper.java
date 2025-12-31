package movies.select.com.br.backend.utils.mapper;

import movies.select.com.br.backend.adapters.outbound.entity.JpaUserEntity;
import movies.select.com.br.backend.domain.user.User;
import movies.select.com.br.backend.domain.user.UserDetailResponse;
import movies.select.com.br.backend.domain.user.UserRequest;
import movies.select.com.br.backend.domain.user.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({
            @Mapping(target = "parties", ignore = true),
            @Mapping(source = "entity.id", target = "id"),
            @Mapping(source = "entity.createdAt", target = "createdAt"),
            @Mapping(source = "entity.updatedAt", target = "updatedAt"),
            @Mapping(source = "entity.activated", target = "activated"),
            @Mapping(source = "entity.email", target = "email"),
            @Mapping(source = "entity.password", target = "password"),
            @Mapping(source = "entity.name", target = "name"),
    })
    User entityToDomain(JpaUserEntity entity);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
            @Mapping(target = "activated", ignore = true),
            @Mapping(target = "parties", ignore = true),
            @Mapping(source = "request.email", target = "email"),
            @Mapping(source = "request.password", target = "password"),
            @Mapping(source = "request.name", target = "name"),
    })
    User requestToDomain(UserRequest request);

    @Mappings({
            @Mapping(source = "domain.id", target = "id"),
            @Mapping(source = "domain.createdAt", target = "createdAt"),
            @Mapping(source = "domain.updatedAt", target = "updatedAt"),
            @Mapping(source = "domain.activated", target = "activated"),
            @Mapping(source = "domain.email", target = "email"),
            @Mapping(source = "domain.name", target = "name"),
    })
    UserResponse domainToResponse(User domain);

    @Mappings({
            @Mapping(target = "parties", ignore = true),
            @Mapping(source = "domain.id", target = "id"),
            @Mapping(source = "domain.createdAt", target = "createdAt"),
            @Mapping(source = "domain.updatedAt", target = "updatedAt"),
            @Mapping(source = "domain.activated", target = "activated"),
            @Mapping(source = "domain.email", target = "email"),
            @Mapping(source = "domain.name", target = "name"),
    })
    UserDetailResponse domainToDetailedResponse(User domain);
}