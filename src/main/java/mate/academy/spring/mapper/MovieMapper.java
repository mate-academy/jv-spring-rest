package mate.academy.spring.mapper;

import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.model.Movie;

public interface MovieMapper extends
        Mapper<MovieRequestDto, MovieResponseDto, Movie> {
}
