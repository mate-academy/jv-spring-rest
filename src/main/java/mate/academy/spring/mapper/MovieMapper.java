package mate.academy.spring.mapper;

import mate.academy.spring.dto.MovieRequest;
import mate.academy.spring.dto.MovieResponse;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public MovieResponse parse(Movie movie) {
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setId(movie.getId());
        movieResponse.setDescription(movie.getDescription());
        movieResponse.setTitle(movie.getTitle());
        return movieResponse;
    }

    public Movie toModel(MovieRequest movieRequest) {
        Movie movie = new Movie();
        movie.setDescription(movieRequest.getDescription());
        movie.setTitle(movieRequest.getTitle());
        return movie;
    }
}
