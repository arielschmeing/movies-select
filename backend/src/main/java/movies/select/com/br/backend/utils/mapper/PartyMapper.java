package movies.select.com.br.backend.utils.mapper;

import movies.select.com.br.backend.adapters.outbound.entity.JpaPartyEntity;
import movies.select.com.br.backend.domain.party.Party;
import movies.select.com.br.backend.domain.party.PartyDetailResponse;
import movies.select.com.br.backend.domain.party.PartyRequest;
import movies.select.com.br.backend.domain.party.PartyResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PartyMapper {
    @Mappings({
            @Mapping(source = "entity.id", target = "id"),
            @Mapping(source = "entity.name", target = "name"),
            @Mapping(source = "entity.owner", target = "owner"),
            @Mapping(source = "entity.users", target = "users"),
            @Mapping(source = "entity.createdAt", target = "createdAt"),
            @Mapping(source = "entity.updatedAt", target = "updatedAt"),
    })
    Party entityToDomain(JpaPartyEntity entity);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
            @Mapping(target = "owner", ignore = true),
            @Mapping(target = "users", ignore = true),
            @Mapping(source = "request.name", target = "name"),
    })
    Party requestToDomain(PartyRequest request);

    @Mappings({
            @Mapping(source = "domain.id", target = "id"),
            @Mapping(source = "domain.name", target = "name"),
            @Mapping(source = "domain.createdAt", target = "createdAt"),
            @Mapping(source = "domain.updatedAt", target = "updatedAt"),
    })
    PartyResponse domainToResponse(Party domain);

    @Mappings({
            @Mapping(target = "owner", ignore = true),
            @Mapping(source = "domain.id", target = "id"),
            @Mapping(source = "domain.name", target = "name"),
            @Mapping(source = "domain.createdAt", target = "createdAt"),
            @Mapping(source = "domain.updatedAt", target = "updatedAt"),
    })
    PartyDetailResponse domainToDetailResponse(Party domain);
}