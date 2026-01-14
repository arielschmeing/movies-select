package movies.select.com.br.backend.application.usecase.movie;

import movies.select.com.br.backend.domain.movie.MovieResponse;

public interface MovieUseCase {
    MovieResponse detail(Long id);
}
