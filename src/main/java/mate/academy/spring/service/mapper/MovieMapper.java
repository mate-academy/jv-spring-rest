package mate.academy.spring.service.mapper;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    private MovieService movieService;

    public MovieMapper(MovieService movieService) {
        this.movieService = movieService;
    }

    public MovieResponseDto parse(Movie movie) {
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        movieResponseDto.setId(movie.getId());
        movieResponseDto.setDescription(movie.getDescription());
        movieResponseDto.setTitle(movie.getTitle());
        return movieResponseDto;
    }

    public List<MovieResponseDto> getAllMovies() {
        return movieService.getAll().stream()
                .map(this::parse)
                .collect(Collectors.toList());
    }

    public Movie toModel(MovieRequestDto requestDto) {
        Movie movie = new Movie();
        movie.setDescription(requestDto.getDescription());
        movie.setTitle(requestDto.getTitle());
        return movie;
    }
}
