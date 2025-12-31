package movies.select.com.br.backend.adapters.outbound.repository.partyOrder;

import lombok.RequiredArgsConstructor;
import movies.select.com.br.backend.adapters.outbound.entity.JpaPartyEntity;
import movies.select.com.br.backend.adapters.outbound.entity.JpaPartyOrderEntity;
import movies.select.com.br.backend.adapters.outbound.entity.JpaUserEntity;
import movies.select.com.br.backend.domain.party.Party;
import movies.select.com.br.backend.domain.party.PartyOrder;
import movies.select.com.br.backend.domain.party.PartyOrderRepository;
import movies.select.com.br.backend.domain.user.User;
import movies.select.com.br.backend.utils.mapper.PartyOrderMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PartyOrderRepositoryImpl implements PartyOrderRepository {

    private final JpaPartyOrderRepository jpaPartyOrderRepository;
    private final PartyOrderMapper partyOrderMapper;

    @Override
    public PartyOrder save(PartyOrder order) {
        JpaPartyOrderEntity orderEntity = new JpaPartyOrderEntity(order);
        this.jpaPartyOrderRepository.save(orderEntity);
        return this.partyOrderMapper.entityToDomain(orderEntity);
    }

    @Override
    public Optional<PartyOrder> findById(UUID id) {
        return this.jpaPartyOrderRepository.findById(id)
                .map(this.partyOrderMapper::entityToDomain);
    }

    @Override
    public List<PartyOrder> findAll() {
        return this.jpaPartyOrderRepository.findAll()
                .stream()
                .map(this.partyOrderMapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        this.jpaPartyOrderRepository.deleteById(id);
    }

    @Override
    public boolean existsByUserAndParty(User user, Party party) {
        return this.jpaPartyOrderRepository.existsByUserAndParty(
                new JpaUserEntity(user),
                new JpaPartyEntity(party));
    }

    @Override
    public List<PartyOrder> findByParty(Party party) {
        return this.jpaPartyOrderRepository.findByParty(new JpaPartyEntity(party))
                .stream()
                .map(this.partyOrderMapper::entityToDomain)
                .collect(Collectors.toList());
    }
}
