package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.movie.MovieRequestDto;
import mate.academy.spring.dto.movie.MovieResponseDto;
import mate.academy.spring.model.Movie;

public interface MovieMapper {
    MovieResponseDto toDto(Movie movie);

    Movie toModel(MovieRequestDto requestDto);
}
