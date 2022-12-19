package mate.academy.spring.mapper;

import mate.academy.spring.dto.request.MovieRequestDto;
import mate.academy.spring.dto.response.MovieResponseDto;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public MovieResponseDto toDto(Movie movie) {
        MovieResponseDto movieDto = new MovieResponseDto();
        movieDto.setId(movie.getId());
        movieDto.setDescription(movie.getDescription());
        movieDto.setTitle(movie.getTitle());
        return movieDto;
    }

    public Movie toModel(MovieRequestDto movieDto) {
        Movie movie = new Movie();
        movie.setDescription(movieDto.getDescription());
        movie.setTitle(movieDto.getTitle());
        return movie;
    }
}
