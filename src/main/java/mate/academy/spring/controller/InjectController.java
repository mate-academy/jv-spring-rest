package mate.academy.spring.controller;

import java.time.LocalDateTime;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class InjectController {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;
    private final MovieSessionService movieSessionService;

    public InjectController(MovieService movieService,
                            CinemaHallService cinemaHallService,
                            MovieSessionService movieSessionService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
        this.movieSessionService = movieSessionService;
    }

    @GetMapping("inject")
    public String inject() {
        Movie movie = new Movie("The Gentlemen");
        movie.setDescription("Best film");
        movieService.add(movie);

        CinemaHall redHall = new CinemaHall();
        redHall.setCapacity(50);
        redHall.setDescription("red");
        cinemaHallService.add(redHall);

        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movie);
        movieSession.setCinemaHall(redHall);
        movieSession.setShowTime(LocalDateTime.now().plusDays(1));
        movieSessionService.add(movieSession);
        return "Done";
    }
}
