package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public MovieResponseDto toDto(Movie movie) {
        return new MovieResponseDto(movie.getId(), movie.getTitle(), movie.getDescription());
    }

    public Movie toModel(MovieRequestDto movieRequestDto) {
        return new Movie(movieRequestDto.getTitle(), movieRequestDto.getDescription());
    }
}
