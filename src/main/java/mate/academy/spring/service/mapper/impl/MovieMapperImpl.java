package mate.academy.spring.service.mapper.impl;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import mate.academy.spring.service.mapper.MovieMapper;
import org.springframework.stereotype.Component;

@Component
public class MovieMapperImpl implements MovieMapper {
    @Override
    public MovieResponseDto toDto(Movie movie) {
        MovieResponseDto dto = new MovieResponseDto();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setDescription(movie.getDescription());
        return dto;
    }

    @Override
    public Movie toModel(MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
        movie.setTitle(movieRequestDto.getTitle());
        movie.setDescription(movieRequestDto.getDescription());
        return movie;
    }
}
