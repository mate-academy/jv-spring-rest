package mate.academy.spring.controller;

import java.time.LocalDateTime;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockDataController {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;
    private final MovieSessionService movieSessionService;

    public MockDataController(MovieService movieService, CinemaHallService cinemaHallService,
                              MovieSessionService movieSessionService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
        this.movieSessionService = movieSessionService;
    }

    @GetMapping
    public String injectMockData() {
        CinemaHall redHall = new CinemaHall();
        redHall.setCapacity(25);
        redHall.setDescription("little hall");

        CinemaHall greenHall = new CinemaHall();
        greenHall.setCapacity(50);
        greenHall.setDescription("middle hall");

        cinemaHallService.add(redHall);
        cinemaHallService.add(greenHall);

        Movie terminator = new Movie();
        terminator.setTitle("Terminator 5");
        terminator.setDescription("Awesome movie");

        Movie avatar = new Movie();
        avatar.setTitle("Avatar");
        avatar.setDescription("Sci-fi movie");

        movieService.add(terminator);
        movieService.add(avatar);

        MovieSession firstMovieSession = new MovieSession();
        firstMovieSession.setMovie(avatar);
        firstMovieSession.setCinemaHall(redHall);
        firstMovieSession.setShowTime(LocalDateTime.now());

        MovieSession secondMovieSession = new MovieSession();
        secondMovieSession.setMovie(terminator);
        secondMovieSession.setCinemaHall(greenHall);
        secondMovieSession.setShowTime(LocalDateTime.now().plusDays(2));

        movieSessionService.add(firstMovieSession);
        movieSessionService.add(secondMovieSession);
        return "Added to DB!";
    }
}
