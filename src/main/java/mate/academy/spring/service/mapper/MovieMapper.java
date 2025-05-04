package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.request.RequestMovie;
import mate.academy.spring.dto.response.ResponseMovie;
import mate.academy.spring.model.Movie;
import mate.academy.spring.service.Mapper;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper implements Mapper
        <Movie, ResponseMovie, RequestMovie> {

    @Override
    public ResponseMovie toDto(Movie movie) {
        ResponseMovie responseMovieDto = new ResponseMovie();
        responseMovieDto.setId(movie.getId());
        responseMovieDto.setDescription(movie.getDescription());
        responseMovieDto.setTitle(movie.getTitle());
        return responseMovieDto;
    }

    @Override
    public Movie toModel(RequestMovie requestDto) {
        Movie movie = new Movie();
        movie.setDescription(requestDto.getDescription());
        movie.setTitle(requestDto.getTitle());
        return movie;
    }
}
