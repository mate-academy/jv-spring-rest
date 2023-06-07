package mate.academy.spring.service;

import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.model.Movie;

public interface MovieMapper {
    MovieResponseDto toDto(Movie movie);

    Movie toModel(MovieRequestDto movieRequestDto);
}
