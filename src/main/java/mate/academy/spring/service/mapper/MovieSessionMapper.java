package mate.academy.spring.service.mapper;

import mate.academy.spring.dto.RequestMovieSessionDto;
import mate.academy.spring.dto.ResponseMovieSessionDto;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    public ResponseMovieSessionDto toDto(MovieSession movieSession) {
        ResponseMovieSessionDto responseMovieSessionDto = new ResponseMovieSessionDto();
        responseMovieSessionDto.setId(movieSession.getId());
        responseMovieSessionDto.setMovieId(movieSession.getMovie().getId());
        responseMovieSessionDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        responseMovieSessionDto.setShowTime(movieSession.getShowTime());
        return responseMovieSessionDto;
    }

    public MovieSession toModel(RequestMovieSessionDto requestMovieSessionDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(new Movie(requestMovieSessionDto.getMovieId()));
        movieSession.setCinemaHall(new CinemaHall(requestMovieSessionDto.getCinemaHallId()));
        movieSession.setShowTime(requestMovieSessionDto.getShowTime());
        return movieSession;
    }
}
