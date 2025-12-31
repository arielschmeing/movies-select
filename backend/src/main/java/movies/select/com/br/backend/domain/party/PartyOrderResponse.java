package movies.select.com.br.backend.domain.party;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import movies.select.com.br.backend.domain.user.UserResponse;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PartyOrderResponse {

    private UUID id;
    private UserResponse user;
    private String partyName;
    private UUID partyId;
    private LocalDateTime createdAt;
}
