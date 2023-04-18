package mate.academy.spring.mapper;

import mate.academy.spring.dto.MovieSessionRequest;
import mate.academy.spring.dto.MovieSessionResponse;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private MovieService movieService;

    private CinemaHallService cinemaHallService;

    @Autowired
    public MovieSessionMapper(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSessionResponse parse(MovieSession movieSession) {
        MovieSessionResponse movieSessionResponse = new MovieSessionResponse();
        movieSessionResponse.setId(movieSession.getId());
        movieSessionResponse.setMovieId(movieSession.getMovie().getId());
        movieSessionResponse.setCinemaHallId(movieSession.getCinemaHall().getId());
        movieSessionResponse.setShowTime(movieSession.getShowTime());
        return movieSessionResponse;
    }

    public MovieSession toModel(MovieSessionRequest movieSessionRequest) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(movieSessionRequest.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(movieSessionRequest.getCinemaHallId()));
        movieSession.setShowTime(movieSessionRequest.getShowTime());
        return movieSession;
    }
}
