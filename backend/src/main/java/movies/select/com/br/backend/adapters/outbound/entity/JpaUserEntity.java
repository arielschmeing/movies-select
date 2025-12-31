package movies.select.com.br.backend.adapters.outbound.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import movies.select.com.br.backend.domain.user.User;
import org.hibernate.annotations.UuidGenerator;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Table(name="user_account")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JpaUserEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    private String name;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean activated;

    @ManyToMany
    private List<JpaPartyEntity> parties = new ArrayList<>();

    public JpaUserEntity(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
        this.activated = user.isActivated();
        this.parties = user.getParties()
                .stream()
                .map(JpaPartyEntity::new)
                .collect(Collectors.toList());
    }
}