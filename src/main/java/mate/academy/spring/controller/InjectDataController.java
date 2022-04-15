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
@RequestMapping("/inject")
public class InjectDataController {
    private final MovieSessionService movieSessionService;
    private final CinemaHallService cinemaHallService;
    private final MovieService movieService;

    public InjectDataController(MovieSessionService movieSessionService,
                                CinemaHallService cinemaHallService, MovieService movieService) {
        this.movieSessionService = movieSessionService;
        this.cinemaHallService = cinemaHallService;
        this.movieService = movieService;
    }

    @GetMapping
    public String injectMockData() {
        CinemaHall bigHall = new CinemaHall();
        bigHall.setCapacity(150);
        bigHall.setDescription("Big hall with 150 places");
        cinemaHallService.add(bigHall);

        CinemaHall smallHall = new CinemaHall();
        smallHall.setCapacity(40);
        smallHall.setDescription("Small hall with 40 places");
        cinemaHallService.add(smallHall);

        Movie fastAndFurious = new Movie("Fast and Furious");
        fastAndFurious.setDescription("An action film about street racing, heists, and spies.");
        movieService.add(fastAndFurious);

        Movie fastAndFurious2 = new Movie("Fast and Furious 2");
        fastAndFurious2.setDescription("Continue. Part 2");
        movieService.add(fastAndFurious2);

        MovieSession fastAndFuriousBigHall = new MovieSession();
        fastAndFuriousBigHall.setCinemaHall(bigHall);
        fastAndFuriousBigHall.setMovie(fastAndFurious);
        fastAndFuriousBigHall.setShowTime(LocalDateTime.now());
        movieSessionService.add(fastAndFuriousBigHall);

        MovieSession fastAndFurious2SmallHall = new MovieSession();
        fastAndFurious2SmallHall.setMovie(fastAndFurious2);
        fastAndFurious2SmallHall.setCinemaHall(smallHall);
        fastAndFurious2SmallHall.setShowTime(LocalDateTime.now().plusDays(1L));
        movieSessionService.add(fastAndFurious2SmallHall);

        return "Insert data to DB!";
    }
}
