package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapperDto {
    public MovieResponseDto parse(Movie movie) {
        return new MovieResponseDto(movie.getId(),movie.getTitle(), movie.getDescription());
    }

    public Movie toModel(MovieRequestDto req) {
        return new Movie(req.getTitle(), req.getDescription());
    }
}
