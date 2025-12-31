package movies.select.com.br.backend.application.service.party;

import lombok.RequiredArgsConstructor;
import movies.select.com.br.backend.adapters.outbound.repository.party.PartyRepositoryImpl;
import movies.select.com.br.backend.application.usecase.party.FindPartyUseCase;
import movies.select.com.br.backend.domain.exception.ApplicationException;
import movies.select.com.br.backend.domain.party.Party;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class FindPartyServiceImpl implements FindPartyUseCase {

    private final PartyRepositoryImpl partyRepository;

    @Override
    public Party byId(UUID id) {
        Optional<Party> party = this.partyRepository.findById(id);
        if (party.isEmpty()) {
            throw new ApplicationException(
                    "user-not-found",
                    String.format("Party with id=%s does not found.", id),
                    NOT_FOUND
            );
        }
        return party.get();
    }
}
