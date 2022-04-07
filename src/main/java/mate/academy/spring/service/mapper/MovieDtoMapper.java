package mate.academy.spring.service.mapper;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieDtoMapper implements Mapper<MovieRequestDto, MovieResponseDto, Movie> {

    public MovieDtoMapper() {
    }

    @Override
    public MovieResponseDto toDto(Movie model) {
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        movieResponseDto.setId(model.getId());
        movieResponseDto.setTitle(model.getTitle());
        movieResponseDto.setDescription(model.getDescription());
        return movieResponseDto;
    }

    @Override
    public Movie toModel(MovieRequestDto modelRequestDto) {
        Movie movie = new Movie();
        movie.setTitle(modelRequestDto.getTitle());
        movie.setDescription(modelRequestDto.getDescription());
        return movie;
    }
}
