package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieDtoMapper {
    public Movie toModel(MovieRequestDto reqDto) {
        Movie movie = new Movie();
        movie.setTitle(reqDto.getTitle());
        movie.setDescription(reqDto.getDescription());
        return movie;
    }

    public MovieResponseDto toDto(Movie movie) {
        MovieResponseDto respDto = new MovieResponseDto();
        respDto.setId(movie.getId());
        respDto.setTitle(movie.getTitle());
        respDto.setDescription(movie.getDescription());
        return respDto;
    }
}
