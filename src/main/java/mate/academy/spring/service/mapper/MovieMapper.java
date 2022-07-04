package mate.academy.spring.service.mapper;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public Movie mapToModel(MovieRequestDto dto) {
        Movie model = new Movie();
        model.setTitle(dto.getTitle());
        model.setDescription(dto.getDescription());
        return model;
    }

    public MovieResponseDto mapToDto(Movie model) {
        MovieResponseDto dto = new MovieResponseDto();
        dto.setId(model.getId());
        dto.setTitle(model.getTitle());
        dto.setDescription(model.getDescription());
        return dto;
    }
}
