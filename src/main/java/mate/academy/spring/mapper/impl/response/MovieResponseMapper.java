package mate.academy.spring.mapper.impl.response;

import mate.academy.spring.dto.response.MovieResponseDto;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieResponseMapper implements DtoResponseMapper<Movie, MovieResponseDto> {
    @Override
    public MovieResponseDto toDto(Movie movie) {
        MovieResponseDto dto = new MovieResponseDto();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setDescription(movie.getDescription());
        return dto;
    }
}
