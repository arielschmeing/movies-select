package movies.select.com.br.backend.adapters.outbound.entity;

import jakarta.persistence.*;
import lombok.*;
import movies.select.com.br.backend.domain.party.Party;
import org.hibernate.annotations.UuidGenerator;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Table(name = "party")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JpaPartyEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    private JpaUserEntity owner;

    @ElementCollection
    @CollectionTable(
            name = "user_party",
            joinColumns = @JoinColumn(name = "party_id")
    )
    @MapKeyJoinColumn(name = "user_id")
    @Column(name = "is_moderator")
    private Map<JpaUserEntity, Boolean> users = new HashMap<>();

    public JpaPartyEntity(Party party) {
        this.id = party.getId();
        this.name = party.getName();
        this.createdAt = party.getCreatedAt();
        this.updatedAt = party.getUpdatedAt();
        this.owner = new JpaUserEntity(party.getOwner());
        this.users = party.getUsers().entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry -> new JpaUserEntity(entry.getKey()),
                        Map.Entry::getValue
                ));
    }
}
