package mate.academy.spring.service.mapper;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public Movie parseToMovie(MovieRequestDto requestDto) {
        Movie movie = new Movie();
        movie.setTitle(requestDto.getTitle());
        movie.setDescription(requestDto.getDescription());
        return movie;
    }

    public MovieResponseDto parseMovieToResponseDto(Movie movie) {
        MovieResponseDto responseDto = new MovieResponseDto();
        responseDto.setId(movie.getId());
        responseDto.setTitle(movie.getTitle());
        responseDto.setDescription(movie.getDescription());
        return responseDto;
    }
}
