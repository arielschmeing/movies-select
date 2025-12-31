package movies.select.com.br.backend.application.usecase.party;

import movies.select.com.br.backend.domain.party.PartyRequest;
import movies.select.com.br.backend.domain.party.PartyResponse;

public interface CreatePartyUseCase {
    PartyResponse create(PartyRequest request, String token);
}
