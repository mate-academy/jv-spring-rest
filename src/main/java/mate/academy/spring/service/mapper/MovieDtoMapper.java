package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponceDto;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieDtoMapper {
    public MovieResponceDto toDto(Movie movie) {
        MovieResponceDto movieResponceDto = new MovieResponceDto();
        movieResponceDto.setTitle(movieResponceDto.getTitle());
        movieResponceDto.setDescription(movie.getDescription());
        movieResponceDto.setId(movie.getId());
        return movieResponceDto;
    }

    public Movie toModel(MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
        movie.setTitle(movieRequestDto.getTitle());
        movie.setDescription(movieRequestDto.getDescription());
        return movie;
    }
}
