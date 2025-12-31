package movies.select.com.br.backend.application.usecase.party;

import movies.select.com.br.backend.domain.party.PartyResponse;
import java.util.UUID;

public interface DetailPartyUseCase {
    PartyResponse detail(UUID id);
}
