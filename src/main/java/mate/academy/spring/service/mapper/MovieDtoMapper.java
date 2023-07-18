package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.movie.MovieRequestDto;
import mate.academy.spring.dto.movie.MovieResponseDto;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieDtoMapper {
    public Movie toModel(MovieRequestDto movieRequestDto) {
        return new Movie(movieRequestDto.getTitle(),
                movieRequestDto.getDescription());
    }

    public MovieResponseDto toDto(Movie movie) {
        return new MovieResponseDto(movie.getId(),
                movie.getTitle(),
                movie.getDescription());
    }
}
