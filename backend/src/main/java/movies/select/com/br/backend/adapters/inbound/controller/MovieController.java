package movies.select.com.br.backend.adapters.inbound.controller;

import lombok.RequiredArgsConstructor;
import movies.select.com.br.backend.application.service.movie.DetailMovieServiceImpl;
import movies.select.com.br.backend.application.usecase.movie.MovieUseCase;
import movies.select.com.br.backend.domain.movie.MovieResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController implements MovieUseCase {

    private final DetailMovieServiceImpl detailMovieService;

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    @Override
    public MovieResponse detail(Long id) {
        return this.detailMovieService.detail(id);
    }
}
