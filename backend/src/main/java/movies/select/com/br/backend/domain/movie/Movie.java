package movies.select.com.br.backend.domain.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    private String backdrop_path;
    private List<MovieGenre> genres;
    private String overview;
    private LocalDate release_date;
    private String title;
    private double vote_average;
}
