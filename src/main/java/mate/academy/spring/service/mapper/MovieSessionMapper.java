package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.request.RequestMovieSession;
import mate.academy.spring.dto.response.ResponseMovieSession;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.Mapper;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper implements Mapper
        <MovieSession, ResponseMovieSession, RequestMovieSession> {

    @Override
    public ResponseMovieSession toDto(MovieSession movieSession) {
        ResponseMovieSession responseMovieSessionDto = new ResponseMovieSession();
        responseMovieSessionDto.setId(movieSession.getId());
        responseMovieSessionDto.setShowTime(movieSession.getShowTime());
        responseMovieSessionDto.setMovieId(movieSession.getMovie().getId());
        responseMovieSessionDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        return responseMovieSessionDto;
    }

    @Override
    public MovieSession toModel(RequestMovieSession requestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setShowTime(requestDto.getShowTime());
        movieSession.setMovie(new Movie(requestDto.getMovieId()));
        movieSession.setCinemaHall(new CinemaHall(requestDto.getCinemaHallId()));
        return movieSession;
    }
}
