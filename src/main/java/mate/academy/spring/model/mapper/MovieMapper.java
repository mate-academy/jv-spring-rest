package mate.academy.spring.model.mapper;

import mate.academy.spring.dto.RequestMovieDto;
import mate.academy.spring.dto.ResponseMovieDto;
import mate.academy.spring.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public ResponseMovieDto toDto(Movie movie) {
        ResponseMovieDto responseMovieDto = new ResponseMovieDto();
        responseMovieDto.setDescription(movie.getDescription());
        responseMovieDto.setId(movie.getId());
        responseMovieDto.setTitle(movie.getTitle());
        return responseMovieDto;
    }

    public Movie toModel(RequestMovieDto requestMovieDto) {
        Movie movie = new Movie();
        movie.setTitle(requestMovieDto.getTitle());
        movie.setDescription(requestMovieDto.getDescription());
        return movie;
    }
}
