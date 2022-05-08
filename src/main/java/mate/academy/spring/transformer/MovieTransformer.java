package mate.academy.spring.transformer;

import mate.academy.spring.dto.MovieDto;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieTransformer {
    public MovieDto toDto(Movie movie) {
        MovieDto dto = new MovieDto();
        dto.setId(movie.getId());
        dto.setDescription(movie.getDescription());
        dto.setTitle(movie.getTitle());
        return dto;
    }

    public Movie fromDto(MovieDto dto) {
        Movie movie = new Movie();
        movie.setId(dto.getId());
        movie.setDescription(dto.getDescription());
        movie.setTitle(dto.getTitle());
        return movie;
    }
}
