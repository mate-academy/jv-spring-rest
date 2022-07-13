package mate.academy.spring.security.mapper;

import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Controller;

@Controller
public class MovieDtoMapper {
    public MovieResponseDto parse(Movie movie) {
        MovieResponseDto response = new MovieResponseDto();
        response.setId(movie.getId());
        response.setTitle(movie.getTitle());
        response.setDescription(movie.getDescription());
        return response;
    }

    public Movie toMovie(MovieRequestDto movieDto) {
        Movie movie = new Movie();
        movie.setDescription(movieDto.getDescription());
        movie.setTitle(movieDto.getTitle());
        return movie;
    }
}
