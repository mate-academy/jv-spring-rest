package mate.academy.spring.service.mapper;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.moviedto.MovieRequestDto;
import mate.academy.spring.model.dto.moviedto.MovieResponseDto;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieDtoMapper {
    private MovieService movieService;

    public MovieDtoMapper(MovieService movieService) {
        this.movieService = movieService;
    }

    public MovieResponseDto toDto(Movie movie) {
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        movieResponseDto.setId(movie.getId());
        movieResponseDto.setTitle(movie.getTitle());
        movieResponseDto.setDescription(movie.getDescription());
        return movieResponseDto;
    }

    public Movie toMovie(MovieRequestDto requestDto) {
        Movie movie = new Movie();
        movie.setDescription(requestDto.getDescription());
        movie.setTitle(requestDto.getTitle());
        return movie;
    }
}
