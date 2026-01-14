package movies.select.com.br.backend.domain.movie;

import movies.select.com.br.backend.domain.party.Party;

import java.time.LocalDateTime;

public class MovieParty {

    private Long id;
    private Party party;
    private Long movieId;
    private boolean wasWatched;
    private boolean wasApproved;
    private LocalDateTime linkedAt;

    public MovieParty() {}

    public MovieParty(
            Long id,
            Party party,
            Long movieId,
            boolean wasWatched,
            boolean wasApproved,
            LocalDateTime linkedAt
    ) {
        this.id = id;
        this.party = party;
        this.movieId = movieId;
        this.wasWatched = wasWatched;
        this.wasApproved = wasApproved;
        this.linkedAt = linkedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public boolean isWasWatched() {
        return wasWatched;
    }

    public void setWasWatched(boolean wasWatched) {
        this.wasWatched = wasWatched;
    }

    public boolean isWasApproved() {
        return wasApproved;
    }

    public void setWasApproved(boolean wasApproved) {
        this.wasApproved = wasApproved;
    }

    public LocalDateTime getLinkedAt() {
        return linkedAt;
    }

    public void setLinkedAt(LocalDateTime linkedAt) {
        this.linkedAt = linkedAt;
    }
}
