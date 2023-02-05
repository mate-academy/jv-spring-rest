package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.model.Movie;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    private MovieService movieService;

    public MovieMapper(MovieService movieService) {
        this.movieService = movieService;
    }

    public MovieResponseDto parse(Movie movie) {
        MovieResponseDto responseDto = new MovieResponseDto();
        responseDto.setDescription(movie.getDescription());
        responseDto.setId(movie.getId());
        responseDto.setTitle(movie.getTitle());
        return responseDto;
    }

    public Movie toModel(MovieRequestDto movieRequestDto)  {
        Movie movie = new Movie();
        movie.setDescription(movieRequestDto.getDescription());
        movie.setTitle(movieRequestDto.getTitle());
        return movie;
    }
}
