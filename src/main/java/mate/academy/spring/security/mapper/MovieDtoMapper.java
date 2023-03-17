package mate.academy.spring.security.mapper;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieDtoMapper {

    public MovieResponseDto toDto(Movie movie) {
        MovieResponseDto responseDto = new MovieResponseDto();
        responseDto.setDescription(movie.getDescription());
        responseDto.setTitle(movie.getTitle());
        responseDto.setId(movie.getId());
        return responseDto;
    }

    public Movie toMovie(MovieRequestDto requestDto) {
        Movie movie = new Movie();
        movie.setDescription(requestDto.getDescription());
        movie.setTitle(requestDto.getTitle());
        return movie;
    }
}