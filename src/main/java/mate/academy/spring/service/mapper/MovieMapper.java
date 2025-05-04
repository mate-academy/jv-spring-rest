package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.movie.MovieRequestDto;
import mate.academy.spring.dto.movie.MovieResponseDto;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public MovieResponseDto toDto(Movie movie) {
        MovieResponseDto responseDto = new MovieResponseDto();
        responseDto.setId(movie.getId());
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
