package mate.academy.spring.mapper.impl;

import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.mapper.MovieRequestMapper;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieRequestMapperImpl implements MovieRequestMapper {
    @Override
    public Movie toModel(MovieRequestDto request) {
        Movie movie = new Movie();
        movie.setTitle(request.getTitle());
        movie.setDescription(request.getDescription());
        return movie;
    }
}
