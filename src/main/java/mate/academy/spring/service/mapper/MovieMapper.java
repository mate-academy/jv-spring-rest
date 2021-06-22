package mate.academy.spring.service.mapper;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public MovieDto mapToDto(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setDescription(movie.getDescription());
        movieDto.setId(movie.getId());
        movieDto.setTitle(movie.getTitle());
        return movieDto;
    }

    public Movie mapToModel(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setId(movieDto.getId());
        movie.setDescription(movieDto.getDescription());
        movie.setTitle(movieDto.getTitle());
        return movie;
    }
}
