package mate.academy.spring.dto.mapper.impl;

import mate.academy.spring.dto.MovieDto;
import mate.academy.spring.dto.mapper.DtoMapper;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper implements DtoMapper<Movie, MovieDto> {
    @Override
    public MovieDto toDto(Movie movie) {
        MovieDto dto = new MovieDto();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setDescription(movie.getDescription());
        return dto;
    }

    @Override
    public Movie toModel(MovieDto dto) {
        Movie movie = new Movie();
        movie.setTitle(dto.getTitle());
        movie.setDescription(dto.getDescription());
        return movie;
    }
}
