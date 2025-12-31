package movies.select.com.br.backend.domain.party;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PartyRepository {
    Party save(Party party);
    Optional<Party> findById(UUID id);
    List<Party> findAll();
    void deleteById(UUID id);
    List<Party> findByOwnerId(UUID id);
}
