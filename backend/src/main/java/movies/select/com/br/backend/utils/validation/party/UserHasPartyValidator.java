package movies.select.com.br.backend.utils.validation.party;

import lombok.RequiredArgsConstructor;
import movies.select.com.br.backend.domain.exception.ApplicationException;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Component
@RequiredArgsConstructor
public class UserHasPartyValidator {

    public void validate(UUID userId, UUID ownerId, UUID partyId) {
        if (!userId.equals(ownerId)) {
            throw new ApplicationException(
                    "user-party-incompatible",
                    String.format("User does not have a party with id=%s.", partyId),
                    NOT_FOUND
            );
        }
    }
}
