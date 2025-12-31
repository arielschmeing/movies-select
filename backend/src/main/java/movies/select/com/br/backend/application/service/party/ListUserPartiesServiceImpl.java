package movies.select.com.br.backend.application.service.party;

import lombok.RequiredArgsConstructor;
import movies.select.com.br.backend.adapters.outbound.repository.party.PartyRepositoryImpl;
import movies.select.com.br.backend.application.service.user.FindUserServiceImpl;
import movies.select.com.br.backend.application.usecase.party.ListUserPartiesUseCase;
import movies.select.com.br.backend.domain.party.PartyResponse;
import movies.select.com.br.backend.utils.mapper.PartyMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListUserPartiesServiceImpl implements ListUserPartiesUseCase {

    private final PartyRepositoryImpl partyRepository;
    private final FindUserServiceImpl findUserService;
    private final PartyMapper partyMapper;

    @Transactional
    @Override
    public List<PartyResponse> list(UUID id) {

        findUserService.byId(id);
        return this.partyRepository.findByOwnerId(id)
                .stream()
                .map(this.partyMapper::domainToResponse)
                .collect(Collectors.toList());
    }
}
