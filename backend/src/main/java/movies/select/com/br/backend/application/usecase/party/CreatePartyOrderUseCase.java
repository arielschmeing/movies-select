package movies.select.com.br.backend.application.usecase.party;

import movies.select.com.br.backend.domain.party.PartyOrderResponse;
import java.util.UUID;

public interface CreatePartyOrderUseCase {
    PartyOrderResponse create(UUID id, String token);
}
