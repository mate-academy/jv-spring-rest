package mate.academy.spring.mapper.request;

import mate.academy.spring.dto.request.MovieRequestDto;
import mate.academy.spring.mapper.Mapper;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieRequestDtoMapper implements Mapper<MovieRequestDto, Movie> {

    @Override
    public Movie map(MovieRequestDto input) {
        Movie movie = new Movie();
        movie.setTitle(input.getTitle());
        movie.setDescription(input.getDescription());
        return movie;
    }
}
