package mate.academy.spring.mapper.request;

import mate.academy.spring.dto.request.MovieSessionRequestDto;
import mate.academy.spring.mapper.Mapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionRequestDtoMapper implements Mapper<MovieSessionRequestDto, MovieSession> {

    private final CinemaHallService cinemaHallService;
    private final MovieService movieService;

    public MovieSessionRequestDtoMapper(CinemaHallService cinemaHallService,
                                        MovieService movieService) {
        this.cinemaHallService = cinemaHallService;
        this.movieService = movieService;
    }

    @Override
    public MovieSession map(MovieSessionRequestDto input) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(input.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(input.getCinemaHallID()));
        movieSession.setShowTime(input.getShowTime());
        return movieSession;
    }
}
