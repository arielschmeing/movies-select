package movies.select.com.br.backend.adapters.outbound.repository.party;

import movies.select.com.br.backend.adapters.outbound.entity.JpaPartyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface JpaPartyRepository extends JpaRepository<JpaPartyEntity, UUID> {
    List<JpaPartyEntity> findByOwnerId(UUID id);
}
