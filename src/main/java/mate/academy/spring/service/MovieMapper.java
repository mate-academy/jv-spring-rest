package mate.academy.spring.service;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;

public interface MovieMapper {
    MovieResponseDto toDto(Movie movie);

    Movie toModel(MovieRequestDto movieRequestDto);
}
