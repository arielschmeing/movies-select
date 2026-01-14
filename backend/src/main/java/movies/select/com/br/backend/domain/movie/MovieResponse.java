package movies.select.com.br.backend.domain.movie;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieResponse {

    private String backdropPath;
    private List<String> genres;
    private String overview;
    private LocalDate release;
    private String title;
    private double average;
}
