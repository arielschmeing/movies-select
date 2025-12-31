package movies.select.com.br.backend.domain.party;

import movies.select.com.br.backend.domain.user.User;
import java.time.LocalDateTime;
import java.util.UUID;

public class PartyOrder {

    private UUID id;
    private Party party;
    private User user;
    private LocalDateTime createdAt;

    public PartyOrder() {}

    public PartyOrder(UUID id, Party party, User user, LocalDateTime createdAt) {
        this.id = id;
        this.party = party;
        this.user = user;
        this.createdAt = createdAt;
    }

    public PartyOrder(Builder builder) {
        this.id = builder.id;
        this.createdAt = builder.createdAt;
        this.party = builder.party;
        this.user = builder.user;
    }

    public static class Builder {
        private UUID id;
        private Party party;
        private User user;
        private LocalDateTime createdAt;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder party(Party party) {
            this.party = party;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public PartyOrder build() {
            return new PartyOrder(this);
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
