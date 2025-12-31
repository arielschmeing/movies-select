package movies.select.com.br.backend.utils.mapper;

import movies.select.com.br.backend.adapters.outbound.entity.JpaPartyOrderEntity;
import movies.select.com.br.backend.domain.party.PartyOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PartyOrderMapper {

    @Mappings({
            @Mapping(source = "entity.id", target = "id"),
            @Mapping(source = "entity.party", target = "party"),
            @Mapping(source = "entity.user", target = "user"),
            @Mapping(source = "entity.createdAt", target = "createdAt"),
    })
    PartyOrder entityToDomain(JpaPartyOrderEntity entity);
}