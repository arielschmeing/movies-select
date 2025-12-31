package movies.select.com.br.backend.application.service.party;

import lombok.RequiredArgsConstructor;
import movies.select.com.br.backend.adapters.outbound.repository.party.PartyRepositoryImpl;
import movies.select.com.br.backend.application.service.user.FindUserServiceImpl;
import movies.select.com.br.backend.application.usecase.party.CreatePartyUseCase;
import movies.select.com.br.backend.domain.party.Party;
import movies.select.com.br.backend.domain.party.PartyRequest;
import movies.select.com.br.backend.domain.party.PartyResponse;
import movies.select.com.br.backend.domain.user.User;
import movies.select.com.br.backend.utils.mapper.PartyMapper;
import movies.select.com.br.backend.utils.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
public class CreatePartyServiceImpl implements CreatePartyUseCase {

    private final FindUserServiceImpl findUserService;
    private final PartyRepositoryImpl partyRepository;
    private final PartyMapper partyMapper;
    private final UserMapper userMapper;

    @Transactional
    @Override
    public PartyResponse create(PartyRequest request, String token) {

        User user = findUserService.byToken(token);
        Party party = partyMapper.requestToDomain(request);
        party.setOwner(user);
        party.setCreatedAt(now());
        party.setUpdatedAt(now());

        Party newParty = this.partyRepository.save(party);

        return this.partyMapper.domainToResponse(newParty);
    }
}
