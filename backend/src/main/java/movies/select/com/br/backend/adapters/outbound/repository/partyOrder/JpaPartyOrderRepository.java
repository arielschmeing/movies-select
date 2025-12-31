package movies.select.com.br.backend.adapters.outbound.repository.partyOrder;

import movies.select.com.br.backend.adapters.outbound.entity.JpaPartyEntity;
import movies.select.com.br.backend.adapters.outbound.entity.JpaPartyOrderEntity;
import movies.select.com.br.backend.adapters.outbound.entity.JpaUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JpaPartyOrderRepository extends JpaRepository<JpaPartyOrderEntity, UUID> {
    boolean existsByUserAndParty(JpaUserEntity user, JpaPartyEntity party);
    List<JpaPartyOrderEntity> findByParty(JpaPartyEntity party);
}
