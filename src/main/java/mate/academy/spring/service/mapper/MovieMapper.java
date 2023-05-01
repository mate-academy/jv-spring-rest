package mate.academy.spring.service.mapper;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;

public interface MovieMapper {
    MovieResponseDto parseToDto(Movie movie);

    Movie parseToModel(MovieRequestDto movieRequestDto);
}
