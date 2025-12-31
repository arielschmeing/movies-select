package movies.select.com.br.backend.domain.party;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PartyRequest(
        @NotBlank(message = "Name cannot be left blank.")
        @Size(
                max = MAX_NAME,
                min = MIN_NAME,
                message = "The name must contain between " + MAX_NAME + " and " + MIN_NAME + " characters."
        )
        String name
) {
   private static final int MAX_NAME = 128;
   private static final int MIN_NAME = 3;
}
