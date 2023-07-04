package mate.academy.spring.mapper;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionRequestMapper {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    public MovieSessionRequestMapper(MovieService movieService,
                                     CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSession fromDto(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(movieSessionRequestDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(movieSessionRequestDto.getCinemaHallId()));
        movieSession.setShowTime(movieSessionRequestDto.getShowTime());
        return movieSession;
    }
}
