package mate.academy.spring.service.mappers;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public MovieResponseDto parseToDto(Movie movie) {
        MovieResponseDto responseDto = new MovieResponseDto();
        responseDto.setDescription(movie.getDescription());
        responseDto.setId(movie.getId());
        responseDto.setTitle(movie.getTitle());
        return responseDto;
    }

    public Movie mappedToModel(MovieRequestDto requestDto) {
        Movie movie = new Movie();
        movie.setDescription(requestDto.getDescription());
        movie.setTitle(requestDto.getTitle());
        return movie;
    }
}
