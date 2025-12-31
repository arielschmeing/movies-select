package movies.select.com.br.backend.domain.party;

import lombok.*;
import movies.select.com.br.backend.domain.user.UserResponse;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PartyDetailResponse extends PartyResponse {
    private UserResponse owner;

    @Builder(builderMethodName = "detailBuilder")
    public PartyDetailResponse(
            UUID id,
            String name,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            Map<UserResponse, Boolean> users,
            UserResponse owner
    ) {
        super(id, name, createdAt, updatedAt, users);
        this.owner = owner;
    }
}
