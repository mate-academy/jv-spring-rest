package mate.academy.spring.service.impl;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import mate.academy.spring.service.MovieMapper;
import org.springframework.stereotype.Service;

@Service
public class MovieMapperImpl implements MovieMapper {
    @Override
    public MovieResponseDto toDto(Movie movie) {
        MovieResponseDto movieDto = new MovieResponseDto();
        movieDto.setTitle(movie.getTitle());
        movieDto.setDescription(movie.getDescription());
        return movieDto;
    }

    @Override
    public Movie toModel(MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
        movie.setDescription(movieRequestDto.getDescription());
        movie.setTitle(movieRequestDto.getTitle());
        return movie;
    }
}
