package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.MovieDto;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieDtoMapper {
    public MovieDto parse(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getId());
        movieDto.setDescription(movie.getDescription());
        movieDto.setTitle(movie.getTitle());
        return movieDto;
    }

    public Movie toModel(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setId(movieDto.getId());
        movie.setDescription(movieDto.getDescription());
        movie.setTitle(movieDto.getTitle());
        return movie;
    }
}
