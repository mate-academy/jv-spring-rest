package mate.academy.spring.service.mapper;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieDtoRequest;
import mate.academy.spring.model.dto.MovieDtoResponse;
import org.springframework.stereotype.Component;

@Component
public class MovieDtoMapper {

    public MovieDtoResponse parse(Movie movie) {
        MovieDtoResponse movieDtoResponse = new MovieDtoResponse();
        movieDtoResponse.setId(movie.getId());
        movieDtoResponse.setTitle(movie.getTitle());
        movieDtoResponse.setDescription(movie.getDescription());
        return movieDtoResponse;
    }

    public Movie toModel(MovieDtoRequest dtoRequest) {
        Movie movie = new Movie();
        movie.setTitle(dtoRequest.getTitle());
        movie.setDescription(dtoRequest.getDescription());
        return movie;
    }
}
