package mate.academy.spring.mapper;

import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.model.Movie;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class MovieDtoMapper {
    public MovieResponseDto toDto(@NonNull Movie movie) {
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        movieResponseDto.setId(movie.getId());
        movieResponseDto.setTitle(movie.getTitle());
        movieResponseDto.setDescription(movie.getDescription());
        return movieResponseDto;
    }

    public Movie toModel(@NonNull MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
        movie.setTitle(movieRequestDto.getTitle());
        movie.setDescription(movieRequestDto.getDescription());
        return movie;
    }
}
