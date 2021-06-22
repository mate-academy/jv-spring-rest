package mate.academy.spring.service.mapper;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieDtoMapper {
    public MovieResponseDto parseToDto(Movie movie) {
        MovieResponseDto userResponseDto =
                new MovieResponseDto(movie.getId(), movie.getTitle(), movie.getDescription());
        return userResponseDto;
    }
    
    public Movie parseToModel(MovieRequestDto movieRequestDto) {
        return new Movie(movieRequestDto.getTitle(), movieRequestDto.getDescription());
    }
}
