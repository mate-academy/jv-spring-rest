package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieDtoMapper {
    public MovieResponseDto toDto(Movie movie) {
        MovieResponseDto responseDto = new MovieResponseDto();
        responseDto.setTitle(movie.getTitle());
        responseDto.setDescription(movie.getDescription());
        return responseDto;
    }

    public Movie toModel(MovieRequestDto requestDto) {
        Movie movie = new Movie();
        movie.setTitle(requestDto.getTitle());
        movie.setDescription(requestDto.getDescription());
        return movie;
    }
}
