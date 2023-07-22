package mate.academy.spring.mapper;

import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieDtoMapper {
    public MovieResponseDto parse(Movie movie) {
        MovieResponseDto responseDto = new MovieResponseDto();
        responseDto.setId(responseDto.getId());
        responseDto.setTitle(responseDto.getTitle());
        responseDto.setDescription(responseDto.getDescription());
        return responseDto;
    }

    public Movie toModel(MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
        movie.setTitle(movie.getTitle());
        movie.setDescription(movie.getDescription());
        return movie;
    }
}
