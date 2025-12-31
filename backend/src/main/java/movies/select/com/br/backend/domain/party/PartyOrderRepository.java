package movies.select.com.br.backend.domain.party;

import movies.select.com.br.backend.domain.user.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PartyOrderRepository {
    PartyOrder save(PartyOrder order);
    Optional<PartyOrder> findById(UUID id);
    List<PartyOrder> findAll();
    void deleteById(UUID id);
    boolean existsByUserAndParty(User user, Party party);
    List<PartyOrder> findByParty(Party party);
}
