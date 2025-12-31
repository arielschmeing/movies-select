package movies.select.com.br.backend.application.service.party;

import lombok.RequiredArgsConstructor;
import movies.select.com.br.backend.domain.party.Party;
import movies.select.com.br.backend.domain.party.PartyOrderResponse;
import movies.select.com.br.backend.domain.user.User;
import movies.select.com.br.backend.utils.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ConvertPartyOrderServiceImpl {

    private final UserMapper userMapper;

    PartyOrderResponse toResponse(Party party, User user, LocalDateTime orderCreatedAt) {
        return PartyOrderResponse.builder()
                .partyName(party.getName())
                .partyId(party.getId())
                .user(this.userMapper.domainToResponse(user))
                .createdAt(orderCreatedAt)
                .build();
    }
}
