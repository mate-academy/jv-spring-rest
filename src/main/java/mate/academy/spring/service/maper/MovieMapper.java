package mate.academy.spring.service.maper;

import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequest;
import mate.academy.spring.model.dto.MovieResponse;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public MovieResponse toDto(Movie movie) {
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setId(movie.getId());
        movieResponse.setDescription(movie.getDescription());
        movieResponse.setTitle(movie.getTitle());
        return  movieResponse;
    }

    public Movie toModel(MovieRequest movieRequest) {
        Movie movie = new Movie();
        movie.setDescription(movieRequest.getDescription());
        movie.setTitle(movie.getTitle());
        return movie;
    }
}
