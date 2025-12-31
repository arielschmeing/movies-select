package movies.select.com.br.backend.utils.validation.party;

import movies.select.com.br.backend.domain.exception.UserAccessDeniedException;
import movies.select.com.br.backend.domain.user.User;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class UserIsModeratorValidator {

    public void validate(User user, Map<User, Boolean> users) {
        if (Boolean.FALSE.equals(users.get(user))) {
            throw new UserAccessDeniedException(user.getId());
        }
    }
}
