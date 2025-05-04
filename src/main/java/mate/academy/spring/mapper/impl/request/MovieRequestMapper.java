package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.dto.request.MovieRequestDto;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieRequestMapper
        implements DtoRequestMapper<Movie, MovieRequestDto> {
    @Override
    public Movie toModel(MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
        movie.setTitle(movieRequestDto.getTitle());
        movie.setDescription(movieRequestDto.getDescription());
        return movie;
    }
}
