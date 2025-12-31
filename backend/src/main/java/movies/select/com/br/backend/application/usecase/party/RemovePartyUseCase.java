package movies.select.com.br.backend.application.usecase.party;

import java.util.UUID;

public interface RemovePartyUseCase {
    void remove(String token, UUID id);
}
