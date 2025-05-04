package mate.academy.spring.service.maper;

import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieDtoMapper {
    public MovieResponseDto toDto(Movie movie) {
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        movieResponseDto.setDescription(movie.getDescription());
        movieResponseDto.setId(movie.getId());
        movieResponseDto.setTitle(movie.getTitle());
        return movieResponseDto;
    }

    public Movie toModel(MovieRequestDto requestDto) {
        Movie movie = new Movie();
        movie.setDescription(requestDto.getDescription());
        movie.setTitle(requestDto.getTitle());
        return movie;
    }
}
