package movies.select.com.br.backend.application.service.party;

import lombok.RequiredArgsConstructor;
import movies.select.com.br.backend.application.usecase.party.DetailPartyUseCase;
import movies.select.com.br.backend.domain.party.Party;
import movies.select.com.br.backend.domain.party.PartyDetailResponse;
import movies.select.com.br.backend.utils.mapper.PartyMapper;
import movies.select.com.br.backend.utils.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DetailPartyServiceImpl implements DetailPartyUseCase {

    private final FindPartyServiceImpl findPartyService;
    private final PartyMapper partyMapper;
    private final UserMapper userMapper;

    @Transactional
    @Override
    public PartyDetailResponse detail(UUID id) {
        Party party = this.findPartyService.byId(id);
        PartyDetailResponse response = this.partyMapper.domainToDetailResponse(party);
        response.setOwner(userMapper.domainToResponse(party.getOwner()));

        return response;
    }
}
