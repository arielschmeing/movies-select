package movies.select.com.br.backend.application.usecase.party;

import movies.select.com.br.backend.domain.party.Party;

import java.util.UUID;

public interface FindPartyUseCase {
    Party byId(UUID id);
}
