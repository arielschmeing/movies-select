package movies.select.com.br.backend.application.service.party;

import lombok.RequiredArgsConstructor;
import movies.select.com.br.backend.adapters.outbound.repository.party.PartyRepositoryImpl;
import movies.select.com.br.backend.application.service.user.FindUserServiceImpl;
import movies.select.com.br.backend.application.usecase.party.GiveModeratorUseCase;
import movies.select.com.br.backend.domain.exception.ApplicationException;
import movies.select.com.br.backend.domain.party.Party;
import movies.select.com.br.backend.domain.user.User;
import movies.select.com.br.backend.utils.validation.party.UserIsOwnerValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@RequiredArgsConstructor
public class GiveModeratorServiceImpl implements GiveModeratorUseCase {

    private final FindUserServiceImpl findUserService;
    private final FindPartyServiceImpl findPartyService;
    private final UserIsOwnerValidator userIsOwnerValidator;
    private final PartyRepositoryImpl partyRepository;

    @Transactional
    @Override
    public void give(UUID partyId, UUID userId, String token) {
        User owner = this.findUserService.byToken(token);
        User user = this.findUserService.byId(userId);
        Party party = this.findPartyService.byId(partyId);

        this.userIsOwnerValidator.validate(owner.getId(), party.getOwner().getId());

        if (Boolean.TRUE.equals(party.getUsers().get(user))) {
            throw new ApplicationException(
                    "user-conflict",
                    String.format("User with id=%s already have moderator", userId),
                    BAD_REQUEST
            );
        }

        party.getUsers().replace(user, true);

        this.partyRepository.save(party);
    }
}
