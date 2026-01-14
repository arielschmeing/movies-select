package movies.select.com.br.backend.application.service.movie;

import lombok.RequiredArgsConstructor;
import movies.select.com.br.backend.application.usecase.movie.DetailMovieUseCase;
import movies.select.com.br.backend.domain.movie.Movie;
import movies.select.com.br.backend.domain.movie.MovieGenre;
import movies.select.com.br.backend.domain.movie.MovieResponse;
import movies.select.com.br.backend.infrastructure.config.ExternalApiInstance;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DetailMovieServiceImpl implements DetailMovieUseCase {

    private final ExternalApiInstance externalApiInstance;

    @Override
    public MovieResponse detail(Long id) {
        URI uri = UriComponentsBuilder
                .fromUriString(id.toString())
                .queryParam("language", "en")
                .build()
                .toUri();

        Mono<Movie> response = this.externalApiInstance.webClient()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(Movie.class);

        Movie movie = Objects.requireNonNull(response.block());
        
        return MovieResponse.builder()
                .title(movie.getTitle())
                .average(movie.getVote_average())
                .backdropPath(movie.getBackdrop_path())
                .genres(movie.getGenres().stream()
                        .map(MovieGenre::getName)
                        .collect(Collectors.toList()))
                .overview(movie.getOverview())
                .release(movie.getRelease_date())
                .build();
    }
}
