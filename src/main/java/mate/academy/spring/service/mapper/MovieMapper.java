package mate.academy.spring.service.mapper;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponceDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public Movie toModel(MovieRequestDto requestDto) {
        Movie movie = new Movie();
        movie.setTitle(requestDto.getTitle());
        movie.setDescription(requestDto.getDescription());
        return movie;
    }

    public MovieResponceDto toDto(Movie movie) {
        MovieResponceDto responceDto = new MovieResponceDto();
        responceDto.setId(movie.getId());
        responceDto.setTitle(movie.getTitle());
        responceDto.setDescription(movie.getDescription());
        return responceDto;
    }
}
