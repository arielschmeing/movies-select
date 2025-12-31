package movies.select.com.br.backend.domain.party;

import movies.select.com.br.backend.domain.user.User;

import java.time.LocalDateTime;
import java.util.*;

public class Party {

    private UUID id;
    private String name;
    private User owner;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    Map<User, Boolean> users = new HashMap<>();

    public Party() {}

    public Party(
            UUID id,
            String name,
            User owner,
            Map<User, Boolean> users,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.users = users;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Map<User, Boolean> getUsers() {
        return users;
    }

    public void setUsers(Map<User, Boolean> users) {
        this.users = users;
    }
}
