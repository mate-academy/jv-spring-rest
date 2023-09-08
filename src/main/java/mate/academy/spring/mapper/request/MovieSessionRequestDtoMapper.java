package mate.academy.spring.mapper.request;

import mate.academy.spring.dto.request.MovieSessionRequestDto;
import mate.academy.spring.mapper.Mapper;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionRequestDtoMapper implements Mapper<MovieSessionRequestDto, MovieSession> {
    @Override
    public MovieSession map(MovieSessionRequestDto input) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(new Movie(input.getMovieId()));
        movieSession.setCinemaHall(new CinemaHall(input.getCinemaHallId()));
        movieSession.setShowTime(input.getShowTime());
        return movieSession;
    }
}

