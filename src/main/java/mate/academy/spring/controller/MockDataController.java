package mate.academy.spring.controller;

import java.time.LocalDateTime;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("inject")
public class MockDataController {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;
    private final MovieSessionService movieSessionService;

    public MockDataController(MovieService movieService,
                              CinemaHallService cinemaHallService,
                              MovieSessionService movieSessionService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
        this.movieSessionService = movieSessionService;
    }

    @GetMapping
    public void inject() {
        Movie movie = new Movie();
        movie.setTitle("MIB");
        movie.setDescription("Good");
        movieService.add(movie);

        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(100);
        cinemaHall.setDescription("Big one");
        cinemaHallService.add(cinemaHall);

        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movie);
        movieSession.setCinemaHall(cinemaHall);
        movieSession.setShowTime(LocalDateTime.now());
        movieSessionService.add(movieSession);
    }
}
