package mate.academy.spring.service.mapper.impl;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import mate.academy.spring.service.mapper.MovieMapper;

public class MovieMapperImpl implements MovieMapper {
    @Override
    public MovieResponseDto parseIntoDto(Movie movie) {
        return new MovieResponseDto(movie.getTitle(), movie.getDescription());
    }

    @Override
    public Movie parseFromDto(MovieRequestDto movieRequestDto) {
        return new Movie(movieRequestDto.getTitle(), movieRequestDto.getDescription());
    }
}
