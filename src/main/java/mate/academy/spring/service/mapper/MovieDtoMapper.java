package mate.academy.spring.service.mapper;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieDtoMapper {
    public MovieResponseDto mapToDto(Movie movie) {
        MovieResponseDto dto = new MovieResponseDto();
        dto.setId(movie.getId());
        dto.setDescription(movie.getDescription());
        dto.setTitle(movie.getTitle());
        return dto;
    }

    public Movie mapToModel(MovieRequestDto dto) {
        Movie movie = new Movie();
        movie.setDescription(dto.getDescription());
        movie.setTitle(dto.getTitle());
        return movie;
    }
}
