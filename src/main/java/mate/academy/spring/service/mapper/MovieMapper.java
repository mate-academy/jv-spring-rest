package mate.academy.spring.service.mapper;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponceDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public MovieResponceDto toDto(Movie movie) {
        MovieResponceDto responceDto = new MovieResponceDto();
        responceDto.setId(movie.getId());
        responceDto.setTitle(movie.getTitle());
        responceDto.setDescription(movie.getDescription());
        return responceDto;
    }

    public Movie toModel(MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
        movie.setTitle(movieRequestDto.getTitle());
        movie.setDescription(movieRequestDto.getDescription());
        return movie;
    }
}
