package mate.academy.spring.service.mapper;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponceDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public MovieResponceDto parseToDto(Movie movie) {
        MovieResponceDto movieResponceDto = new MovieResponceDto();
        movieResponceDto.setId(movie.getId());
        movieResponceDto.setDescription(movie.getDescription());
        movieResponceDto.setTitle(movie.getTitle());
        return movieResponceDto;
    }

    public Movie parseToModel(MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
        movie.setTitle(movieRequestDto.getTitle());
        movie.setDescription(movieRequestDto.getDescription());
        return movie;
    }
}
