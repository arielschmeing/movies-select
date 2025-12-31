package movies.select.com.br.backend.adapters.outbound.repository.party;

import lombok.RequiredArgsConstructor;
import movies.select.com.br.backend.adapters.outbound.entity.JpaPartyEntity;
import movies.select.com.br.backend.domain.party.Party;
import movies.select.com.br.backend.domain.party.PartyRepository;
import movies.select.com.br.backend.utils.mapper.PartyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PartyRepositoryImpl implements PartyRepository {

    private final JpaPartyRepository jpaPartyRepository;
    private final PartyMapper partyMapper;

    @Override
    public Party save(Party party) {
        JpaPartyEntity partyEntity = new JpaPartyEntity(party);
        this.jpaPartyRepository.save(partyEntity);
        return this.partyMapper.entityToDomain(partyEntity);
    }

    @Override
    public Optional<Party> findById(UUID id) {
        return this.jpaPartyRepository.findById(id).map(this.partyMapper::entityToDomain);
    }

    @Override
    public List<Party> findAll() {
        return this.jpaPartyRepository.findAll()
                .stream()
                .map(this.partyMapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        this.jpaPartyRepository.deleteById(id);
    }

    @Override
    public List<Party> findByOwnerId(UUID id) {
        return this.jpaPartyRepository.findByOwnerId(id)
                .stream()
                .map(this.partyMapper::entityToDomain)
                .collect(Collectors.toList());
    }
}
