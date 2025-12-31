package movies.select.com.br.backend.application.service.party;

import lombok.RequiredArgsConstructor;
import movies.select.com.br.backend.adapters.outbound.repository.partyOrder.PartyOrderRepositoryImpl;
import movies.select.com.br.backend.application.service.user.FindUserServiceImpl;
import movies.select.com.br.backend.application.usecase.party.ListPartyOrdersUseCase;
import movies.select.com.br.backend.domain.exception.UserAccessDeniedException;
import movies.select.com.br.backend.domain.party.Party;
import movies.select.com.br.backend.domain.party.PartyOrderResponse;
import movies.select.com.br.backend.domain.user.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListPartyOrdersServiceImpl implements ListPartyOrdersUseCase {

    private final FindPartyServiceImpl findPartyService;
    private final PartyOrderRepositoryImpl partyOrderRepository;
    private final FindUserServiceImpl findUserService;
    private final ConvertPartyOrderServiceImpl convertPartyOrderService;

    @Transactional
    @Override
    public List<PartyOrderResponse> list(UUID id, String token) {
        Party party = this.findPartyService.byId(id);
        User user = this.findUserService.byToken(token);

        if (!Objects.equals(user.getId(), party.getOwner().getId()) ||
                Boolean.FALSE.equals(party.getUsers().get(user))) {
            throw new UserAccessDeniedException(user.getId());
        }

        return this.partyOrderRepository.findByParty(party).stream()
                .map(o -> this.convertPartyOrderService.toResponse(party, user, o.getCreatedAt()))
                .collect(Collectors.toList());
    }
}
