package movies.select.com.br.backend.application.usecase.party;

import movies.select.com.br.backend.domain.party.*;

import java.util.List;
import java.util.UUID;

public interface PartyUseCase {
    PartyResponse create(PartyRequest request, String token);
    List<PartyResponse> userParties(UUID id);
    PartyDetailResponse detail(UUID id);
    void remove(String token, UUID id);
    PartyOrderResponse createOrder(UUID id, String token);
    List<PartyOrderResponse> listPartyOrders(UUID id, String token);
    void acceptOrder(UUID orderId, String token);
    void giveModerator(UUID partyId, UUID userId, String token);
}
