package mate.academy.spring.config;

import java.time.LocalDateTime;
import javax.annotation.PostConstruct;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.stereotype.Component;

@Component
public class AppInitializer {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;
    private final MovieSessionService movieSessionService;

    public AppInitializer(MovieService movieService, CinemaHallService cinemaHallService,
                          MovieSessionService movieSessionService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
        this.movieSessionService = movieSessionService;
    }

    @PostConstruct
    public String initialize() {
        Movie fastAndFurious = new Movie("Fast and Furious");
        fastAndFurious.setDescription("An action film about street racing, heists, and spies.");
        movieService.add(fastAndFurious);
        System.out.println(movieService.get(fastAndFurious.getId()));
        movieService.getAll().forEach(System.out::println);

        CinemaHall redCinemaHall = new CinemaHall();
        redCinemaHall.setName("RED CINEMA HAll");
        redCinemaHall.setCapacity(200);
        redCinemaHall.setDescription("red cinema hall with capacity 200");

        CinemaHall blueCinemaHall = new CinemaHall();
        blueCinemaHall.setName("BLUE CINEMA HAll");
        blueCinemaHall.setCapacity(100);
        blueCinemaHall.setDescription("blue cinema hall with capacity 100");

        cinemaHallService.add(redCinemaHall);
        cinemaHallService.add(blueCinemaHall);

        MovieSession tomorrowMovieSession = new MovieSession();
        tomorrowMovieSession.setCinemaHall(redCinemaHall);
        tomorrowMovieSession.setMovie(fastAndFurious);
        tomorrowMovieSession.setShowTime(LocalDateTime.now().plusDays(1L));

        MovieSession yesterdayMovieSession = new MovieSession();
        yesterdayMovieSession.setCinemaHall(redCinemaHall);
        yesterdayMovieSession.setMovie(fastAndFurious);
        yesterdayMovieSession.setShowTime(LocalDateTime.now().minusDays(1L));

        movieSessionService.add(tomorrowMovieSession);
        movieSessionService.add(yesterdayMovieSession);

        return "Initialized!";
    }
}
