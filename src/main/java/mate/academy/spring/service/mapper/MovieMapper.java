package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public MovieResponseDto toResponseDto(Movie model) {
        MovieResponseDto responseDto = new MovieResponseDto();
        responseDto.setId(model.getId());
        responseDto.setTitle(model.getTitle());
        responseDto.setDescription(model.getDescription());
        return responseDto;
    }

    public MovieRequestDto toRequestDto(Movie model) {
        MovieRequestDto requestDto = new MovieRequestDto();
        requestDto.setTitle(model.getTitle());
        requestDto.setDescription(model.getDescription());
        return requestDto;
    }

    public Movie toModel(MovieRequestDto requestDto) {
        Movie model = new Movie();
        model.setTitle(requestDto.getTitle());
        model.setDescription(requestDto.getDescription());
        return model;
    }

    public Movie toModel(MovieResponseDto responseDto) {
        Movie model = new Movie();
        model.setId(responseDto.getId());
        model.setTitle(responseDto.getTitle());
        model.setDescription(responseDto.getDescription());
        return model;
    }
}
