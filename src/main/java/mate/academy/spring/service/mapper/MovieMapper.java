package mate.academy.spring.service.mapper;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.requests.MovieRequestDto;
import mate.academy.spring.model.dto.responses.MovieResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public MovieResponseDto parseToResponseDto(Movie movie) {
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        movieResponseDto.setId(movie.getId());
        movieResponseDto.setTitle(movie.getTitle());
        movieResponseDto.setDescription(movie.getDescription());
        return movieResponseDto;
    }

    public Movie toModel(MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
        movie.setTitle(movieRequestDto.getTitle());
        movie.setDescription(movieRequestDto.getDescription());
        return movie;
    }
}
