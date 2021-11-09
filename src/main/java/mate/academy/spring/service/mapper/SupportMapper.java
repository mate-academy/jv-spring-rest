package mate.academy.spring.service.mapper;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SupportMapper {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    @Autowired
    public SupportMapper(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSession movieSessionRequestDtoToMovieSession(MovieSessionRequestDto dto) {
        MovieSession session = new MovieSession();
        session.setMovie(movieService.get(dto.getMovieId()));
        session.setCinemaHall(cinemaHallService.get(dto.getCinemaHallId()));
        session.setShowTime(dto.getShowTime());
        return session;
    }
}
