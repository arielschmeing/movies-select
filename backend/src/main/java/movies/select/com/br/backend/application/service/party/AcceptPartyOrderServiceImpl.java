package movies.select.com.br.backend.application.service.party;

import lombok.RequiredArgsConstructor;
import movies.select.com.br.backend.adapters.outbound.repository.party.PartyRepositoryImpl;
import movies.select.com.br.backend.adapters.outbound.repository.partyOrder.PartyOrderRepositoryImpl;
import movies.select.com.br.backend.application.service.user.FindUserServiceImpl;
import movies.select.com.br.backend.application.usecase.party.AcceptPartyOrderUseCase;
import movies.select.com.br.backend.domain.exception.ApplicationException;
import movies.select.com.br.backend.domain.party.PartyOrder;
import movies.select.com.br.backend.domain.user.User;
import movies.select.com.br.backend.utils.validation.party.UserIsModeratorValidator;
import movies.select.com.br.backend.utils.validation.party.UserIsOwnerValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class AcceptPartyOrderServiceImpl implements AcceptPartyOrderUseCase {

    private final FindUserServiceImpl findUserService;
    private final PartyOrderRepositoryImpl partyOrderRepository;
    private final PartyRepositoryImpl partyRepository;
    private final UserIsModeratorValidator userIsModeratorValidator;
    private final UserIsOwnerValidator userIsOwnerValidator;

    @Transactional
    @Override
    public void accept(UUID orderId, String token) {

        User user = this.findUserService.byToken(token);
        PartyOrder order = this.partyOrderRepository.findById(orderId)
                .orElseThrow(() -> new ApplicationException(
                        "order-not-found",
                        String.format("Order with id=%s not found.", orderId),
                        NOT_FOUND
                ));

        this.userIsOwnerValidator.validate(user.getId(), order.getParty().getOwner().getId());
        this.userIsModeratorValidator.validate(user, order.getParty().getUsers());

        order.getParty().getUsers().put(order.getUser(), false);

        this.partyRepository.save(order.getParty());
        this.partyOrderRepository.deleteById(orderId);
    }
}
