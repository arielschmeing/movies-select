package movies.select.com.br.backend.utils.validation.party;

import movies.select.com.br.backend.domain.exception.UserAccessDeniedException;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class UserIsOwnerValidator {

    public void validate(UUID userId, UUID partyOwnerId) {
        if (!Objects.equals(userId, partyOwnerId)) {
            throw new UserAccessDeniedException(userId);
        }
    }
}
