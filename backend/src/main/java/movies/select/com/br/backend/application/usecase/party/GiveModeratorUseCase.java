package movies.select.com.br.backend.application.usecase.party;

import java.util.UUID;

public interface GiveModeratorUseCase {
    void give(UUID partyId, UUID userId, String token);
}
