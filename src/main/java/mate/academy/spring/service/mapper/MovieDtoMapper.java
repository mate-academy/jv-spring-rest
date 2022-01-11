package mate.academy.spring.service.mapper;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieDtoMapper {
    public MovieResponseDto toDto(Movie movie) {
        return MovieResponseDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .build();
    }

    public Movie toModel(MovieRequestDto requestDto) {
        return Movie.builder()
                .title(requestDto.getTitle())
                .description(requestDto.getDescription())
                .build();
    }
}
