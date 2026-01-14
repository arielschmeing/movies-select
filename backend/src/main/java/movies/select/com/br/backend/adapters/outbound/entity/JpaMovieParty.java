package movies.select.com.br.backend.adapters.outbound.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import movies.select.com.br.backend.domain.party.Party;
import java.time.LocalDateTime;
import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JpaMovieParty {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    private Party party;

    private Long movieId;
    private boolean wasWatched;
    private boolean wasApproved;
    private LocalDateTime linkedAt;
}
