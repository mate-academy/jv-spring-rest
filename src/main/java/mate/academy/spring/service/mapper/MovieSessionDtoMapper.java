package mate.academy.spring.service.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionDtoRequest;
import mate.academy.spring.model.dto.MovieSessionDtoResponse;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionDtoMapper {

    public MovieSessionDtoResponse parse(MovieSession movieSession) {
        MovieSessionDtoResponse movieSessionDtoResponse = new MovieSessionDtoResponse();
        movieSessionDtoResponse.setId(movieSession.getId());
        movieSessionDtoResponse.setMovieId(movieSession.getId());
        movieSessionDtoResponse.setCinemaHallId(movieSession.getCinemaHall().getId());
        movieSessionDtoResponse.setShowTime(movieSession.getShowTime());
        return movieSessionDtoResponse;
    }

    public MovieSession toModel(MovieSessionDtoRequest movieSessionRequest) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(new Movie(movieSessionRequest.getMovieId()));
        movieSession.setCinemaHall(new CinemaHall(movieSessionRequest.getCinemaHallId()));
        movieSession.setShowTime(movieSessionRequest.getShowTime());
        return movieSession;
    }
}
