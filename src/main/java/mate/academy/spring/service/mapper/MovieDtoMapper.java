package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.requests.MovieDtoRequest;
import mate.academy.spring.dto.responses.MovieDtoResponse;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieDtoMapper {
    public MovieDtoResponse toDto(Movie movie) {
        MovieDtoResponse movieDtoRequest = new MovieDtoResponse();
        movieDtoRequest.setDescription(movie.getDescription());
        movieDtoRequest.setTitle(movie.getTitle());
        movieDtoRequest.setId(movie.getId());
        return movieDtoRequest;
    }

    public Movie toModel(MovieDtoRequest movieDtoResponse) {
        Movie movie = new Movie();
        movie.setDescription(movieDtoResponse.getDescription());
        movie.setTitle(movieDtoResponse.getTitle());
        return movie;
    }
}
