package mate.academy.spring.service.mapper;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import org.springframework.stereotype.Component;

@Component
public class MovieDtoMapper {

    public MovieRequestDto toDto(Movie movie) {
        MovieRequestDto responseDto = new MovieRequestDto();
        responseDto.setId(movie.getId());
        responseDto.setTitle(movie.getTitle());
        responseDto.setDescription(movie.getDescription());
        return responseDto;
    }

    public Movie toModel(MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
        movie.setDescription(movie.getDescription());
        movie.setTitle(movie.getTitle());
        return movie;
    }
}
