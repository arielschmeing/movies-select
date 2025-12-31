package movies.select.com.br.backend.application.usecase.party;

import movies.select.com.br.backend.domain.party.PartyResponse;

import java.util.List;
import java.util.UUID;

public interface ListUserPartiesUseCase {
    List<PartyResponse> list(UUID id);
}
