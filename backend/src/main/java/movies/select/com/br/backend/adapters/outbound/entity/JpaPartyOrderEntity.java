package movies.select.com.br.backend.adapters.outbound.entity;

import jakarta.persistence.*;
import lombok.*;
import movies.select.com.br.backend.domain.party.PartyOrder;
import org.hibernate.annotations.UuidGenerator;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "party_order")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JpaPartyOrderEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "party_id")
    private JpaPartyEntity party;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private JpaUserEntity user;
    private LocalDateTime createdAt;

    public JpaPartyOrderEntity(PartyOrder order) {
        this.id = order.getId();
        this.createdAt = order.getCreatedAt();
        this.user = new JpaUserEntity(order.getUser());
        this.party = new JpaPartyEntity(order.getParty());
    }
}
