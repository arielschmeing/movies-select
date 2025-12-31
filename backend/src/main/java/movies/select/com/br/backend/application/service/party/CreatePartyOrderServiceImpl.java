package movies.select.com.br.backend.application.service.party;

import lombok.RequiredArgsConstructor;
import movies.select.com.br.backend.adapters.outbound.repository.partyOrder.PartyOrderRepositoryImpl;
import movies.select.com.br.backend.application.service.user.FindUserServiceImpl;
import movies.select.com.br.backend.application.usecase.party.CreatePartyOrderUseCase;
import movies.select.com.br.backend.domain.exception.ApplicationException;
import movies.select.com.br.backend.domain.party.Party;
import movies.select.com.br.backend.domain.party.PartyOrder;
import movies.select.com.br.backend.domain.party.PartyOrderResponse;
import movies.select.com.br.backend.domain.user.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@RequiredArgsConstructor
public class CreatePartyOrderServiceImpl implements CreatePartyOrderUseCase {

    private final FindUserServiceImpl findUserService;
    private final FindPartyServiceImpl findPartyService;
    private final PartyOrderRepositoryImpl partyOrderRepository;
    private final ConvertPartyOrderServiceImpl convertPartyOrderService;

    @Transactional
    @Override
    public PartyOrderResponse create(UUID id, String token) {
        User user = this.findUserService.byToken(token);
        Party party = this.findPartyService.byId(id);

        if (Objects.equals(user.getId(), party.getOwner().getId()) ||
                party.getUsers().containsKey(user)) {
            throw new ApplicationException(
                    "user-in-party",
                    String.format("User already in party id=%s.", id),
                    BAD_REQUEST
            );
        }

        if (this.partyOrderRepository.existsByUserAndParty(user, party)) {
            throw new ApplicationException(
                    "user-order-created",
                    String.format("User already has a order in id=%s party.", id),
                    BAD_REQUEST
            );
        }

        PartyOrder order = this.partyOrderRepository.save(new PartyOrder.Builder()
                .createdAt(now())
                .party(party)
                .user(user)
                .build());

        return this.convertPartyOrderService.toResponse(party, user, order.getCreatedAt());
    }
}
