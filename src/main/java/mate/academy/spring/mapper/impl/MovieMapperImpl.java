package mate.academy.spring.mapper.impl;

import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.mapper.MovieMapper;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapperImpl implements MovieMapper {
    @Override
    public Movie toModel(MovieRequestDto request) {
        Movie movie = new Movie();
        movie.setTitle(request.getTitle());
        movie.setDescription(request.getDescription());
        return movie;
    }

    @Override
    public MovieResponseDto toDto(Movie entity) {
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        movieResponseDto.setId(entity.getId());
        movieResponseDto.setTitle(entity.getTitle());
        movieResponseDto.setDescription(entity.getDescription());
        return movieResponseDto;
    }
}
