package movies.select.com.br.backend.domain.user;

import lombok.*;
import movies.select.com.br.backend.domain.party.PartyResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class UserDetailResponse extends UserResponse {

    private List<PartyResponse> parties;

    @Builder(builderMethodName = "detailedBuilder")
    public UserDetailResponse(
            UUID id, String name,
            String email,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            boolean activated,
            List<PartyResponse> parties
    ) {
        super(id, name, email, createdAt, updatedAt, activated);
        this.parties = parties;
    }
}
