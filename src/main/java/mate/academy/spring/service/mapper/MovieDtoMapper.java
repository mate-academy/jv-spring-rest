package mate.academy.spring.service.mapper;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieDtoMapper {
    public MovieResponseDto toDto(Movie movie) {
        MovieResponseDto movieResponse = new MovieResponseDto();
        movieResponse.setId(movie.getId());
        movieResponse.setDescription(movie.getDescription());
        movieResponse.setTitle(movie.getTitle());
        return movieResponse;
    }

    public Movie toModel(MovieRequestDto movieRequest) {
        Movie movie = new Movie();
        movie.setDescription(movieRequest.getDescription());
        movie.setTitle(movieRequest.getTitle());
        return movie;
    }
}
