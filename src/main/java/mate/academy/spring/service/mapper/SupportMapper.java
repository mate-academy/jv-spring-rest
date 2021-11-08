package mate.academy.spring.service.mapper;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SupportMapper {
    private final MovieSessionService movieSessionService;
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    @Autowired
    public SupportMapper(MovieSessionService movieSessionService, MovieService movieService,
                         CinemaHallService cinemaHallService) {
        this.movieSessionService = movieSessionService;
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSession movieSessionRequestDtoToMovieSession(MovieSessionRequestDto dto) {
        MovieSession session = new MovieSession();
        session.setMovie(movieService.get(dto.getMovieId()));
        session.setCinemaHall(cinemaHallService.get(dto.getCinemaHallId()));
        session.setShowTime(dto.getShowTime());
        return movieSessionService.add(session);
    }

    public void update(Long id, MovieSessionRequestDto dto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setId(id);
        movieSession.setMovie(movieService.get(dto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(dto.getCinemaHallId()));
        movieSession.setShowTime(dto.getShowTime());
        movieSessionService.update(movieSession);
    }
}
