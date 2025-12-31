package movies.select.com.br.backend.application.usecase.party;

import java.util.UUID;

public interface AcceptPartyOrderUseCase {
    void accept(UUID orderId, String token);
}
