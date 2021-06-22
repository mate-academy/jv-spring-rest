package mate.academy.spring.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.annotation.PostConstruct;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InjectTestData {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;
    private final MovieSessionService movieSessionService;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Autowired
    public InjectTestData(MovieService movieService, CinemaHallService cinemaHallService,
                          MovieSessionService movieSessionService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
        this.movieSessionService = movieSessionService;
    }

    @PostConstruct
    public String injectTestData() {
        Movie firstMovie = new Movie();
        firstMovie.setTitle("Terminator");
        firstMovie.setDescription("Very terminator's movie");
        movieService.add(firstMovie);

        Movie secondMovie = new Movie();
        secondMovie.setTitle("Terminator 2");
        secondMovie.setDescription("Terminator 2 is better then the first");
        movieService.add(secondMovie);

        Movie thirdMovie = new Movie();
        thirdMovie.setTitle("Terminator 3");
        thirdMovie.setDescription("Trash");
        movieService.add(thirdMovie);

        CinemaHall alfaCinemaHall = new CinemaHall();
        alfaCinemaHall.setCapacity(100);
        alfaCinemaHall.setDescription("Medium cinema hall alfa");
        cinemaHallService.add(alfaCinemaHall);

        CinemaHall betaCinemaHall = new CinemaHall();
        betaCinemaHall.setCapacity(50);
        betaCinemaHall.setDescription("Medium cinema hall beta");
        cinemaHallService.add(betaCinemaHall);

        CinemaHall gammaCinemaHall = new CinemaHall();
        gammaCinemaHall.setCapacity(40);
        gammaCinemaHall.setDescription("Medium cinema hall gamma");
        cinemaHallService.add(gammaCinemaHall);

        MovieSession movieSession1 = new MovieSession();
        movieSession1.setMovie(firstMovie);
        movieSession1.setCinemaHall(alfaCinemaHall);
        movieSession1.setShowTime(LocalDateTime.parse("2021-06-23 12:30", formatter));

        MovieSession movieSession2 = new MovieSession();
        movieSession2.setMovie(secondMovie);
        movieSession2.setCinemaHall(betaCinemaHall);
        movieSession2.setShowTime(LocalDateTime.parse("2021-06-24 14:30", formatter));

        MovieSession movieSession3 = new MovieSession();
        movieSession3.setMovie(secondMovie);
        movieSession3.setCinemaHall(betaCinemaHall);
        movieSession3.setShowTime(LocalDateTime.parse("2021-06-26 14:30", formatter));

        MovieSession movieSession4 = new MovieSession();
        movieSession4.setMovie(thirdMovie);
        movieSession4.setCinemaHall(gammaCinemaHall);
        movieSession4.setShowTime(LocalDateTime.parse("2021-06-24 19:30", formatter));

        movieSessionService.add(movieSession1);
        movieSessionService.add(movieSession2);
        movieSessionService.add(movieSession3);
        movieSessionService.add(movieSession4);

        return "Test data injected";
    }
}
