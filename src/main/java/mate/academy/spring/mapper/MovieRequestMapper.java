package mate.academy.spring.mapper;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import org.springframework.stereotype.Component;

@Component
public class MovieRequestMapper {
    public Movie fromDto(MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
        movie.setDescription(movieRequestDto.getDescription());
        movie.setTitle(movieRequestDto.getTitle());
        return movie;
    }
}
