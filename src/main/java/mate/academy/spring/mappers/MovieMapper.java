package mate.academy.spring.mappers;

import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public MovieResponseDto toDto(Movie movie) {
        MovieResponseDto dto = new MovieResponseDto();
        dto.setId(movie.getId());
        dto.setDescription(movie.getDescription());
        dto.setTitle(movie.getTitle());
        return dto;
    }

    public Movie fromDto(MovieRequestDto dto) {
        Movie movie = new Movie();
        movie.setId(dto.getId());
        movie.setDescription(dto.getDescription());
        movie.setTitle(dto.getTitle());
        return movie;
    }
}
