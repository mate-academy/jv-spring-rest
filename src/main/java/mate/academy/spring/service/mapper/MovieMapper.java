package mate.academy.spring.service.mapper;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public MovieResponseDto toDto(Movie movie) {
        return new MovieResponseDto(movie.getId(),
                movie.getTitle(),
                movie.getDescription());
    }

    public Movie toModel(MovieRequestDto requestDto) {
        return new Movie(requestDto.getTitle(),
                requestDto.getDescription());
    }
}
