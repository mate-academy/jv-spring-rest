package mate.academy.spring.mapper.impl;

import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.mapper.MovieResponseMapper;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieResponseMapperImpl implements MovieResponseMapper {
    @Override
    public MovieResponseDto toDto(Movie model) {
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        movieResponseDto.setId(model.getId());
        movieResponseDto.setTitle(model.getTitle());
        movieResponseDto.setDescription(model.getDescription());
        return movieResponseDto;
    }
}
