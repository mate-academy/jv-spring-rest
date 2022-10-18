package mate.academy.spring.service.mapper;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieDtoRequest;
import mate.academy.spring.model.dto.MovieDtoResponse;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public MovieDtoResponse toDto(Movie movie) {
        MovieDtoResponse movieResponseDto = new MovieDtoResponse();
        movieResponseDto.setId(movie.getId());
        movieResponseDto.setDescription(movie.getDescription());
        movieResponseDto.setTitle(movie.getTitle());
        return movieResponseDto;
    }

    public Movie toModel(MovieDtoRequest movieRequestDto) {
        Movie movie = new Movie();
        movie.setTitle(movieRequestDto.getTitle());
        movie.setDescription(movieRequestDto.getDescription());
        return movie;
    }
}
