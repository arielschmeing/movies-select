package movies.select.com.br.backend.application.service.party;

import lombok.RequiredArgsConstructor;
import movies.select.com.br.backend.adapters.outbound.repository.party.PartyRepositoryImpl;
import movies.select.com.br.backend.application.service.user.FindUserServiceImpl;
import movies.select.com.br.backend.application.usecase.party.RemovePartyUseCase;
import movies.select.com.br.backend.domain.party.Party;
import movies.select.com.br.backend.domain.user.User;
import movies.select.com.br.backend.utils.validation.party.UserHasPartyValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RemovePartyServiceImpl implements RemovePartyUseCase {

    private final PartyRepositoryImpl partyRepository;
    private final FindUserServiceImpl findUserService;
    private final FindPartyServiceImpl findPartyService;
    private final UserHasPartyValidator userHasPartyValidator;

    @Transactional
    @Override
    public void remove(String token, UUID id) {
        User user = findUserService.byToken(token);
        Party party = findPartyService.byId(id);

        this.userHasPartyValidator.validate(
                user.getId(),
                party.getOwner().getId(),
                party.getId()
        );

        this.partyRepository.deleteById(id);
    }
}
