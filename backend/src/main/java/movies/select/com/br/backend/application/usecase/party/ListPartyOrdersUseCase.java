package movies.select.com.br.backend.application.usecase.party;

import movies.select.com.br.backend.domain.party.PartyOrderResponse;

import java.util.List;
import java.util.UUID;

public interface ListPartyOrdersUseCase {
    List<PartyOrderResponse> list(UUID id, String token);
}
