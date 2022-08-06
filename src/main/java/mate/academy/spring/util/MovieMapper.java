package mate.academy.spring.util;

import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public MovieResponseDto toDto(Movie movie) {
        MovieResponseDto responseMovieDto = new MovieResponseDto();
        responseMovieDto.setDescription(movie.getDescription());
        responseMovieDto.setId(movie.getId());
        responseMovieDto.setTitle(movie.getTitle());
        return responseMovieDto;
    }

    public Movie toModel(MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
        movie.setDescription(movieRequestDto.getDescription());
        movie.setTitle(movieRequestDto.getTitle());
        return movie;
    }

}
