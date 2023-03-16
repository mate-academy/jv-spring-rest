package mate.academy.spring;

import java.time.LocalDateTime;
import mate.academy.spring.config.AppConfig;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        final MovieService movieService = context.getBean(MovieService.class);
        final CinemaHallService cinemaHallService = context.getBean(CinemaHallService.class);
        final MovieSessionService movieSessionService = context.getBean(MovieSessionService.class);

        Movie terminator = new Movie();
        terminator.setTitle("Terminator");
        terminator.setDescription("Favorite film");

        Movie matrix = new Movie();
        matrix.setTitle("Matrix");
        matrix.setDescription("Cool film");

        Movie born = new Movie();
        born.setTitle("Born idetification");
        born.setDescription("Super film");

        movieService.add(terminator);
        movieService.add(matrix);
        movieService.add(born);

        CinemaHall small = new CinemaHall();
        small.setCapacity(200);
        small.setDescription("lkjflkjf");

        CinemaHall medium = new CinemaHall();
        medium.setCapacity(250);
        medium.setDescription("ölfkvölkdf");

        CinemaHall large = new CinemaHall();
        large.setCapacity(300);
        large.setDescription("ölkfökkfl");

        cinemaHallService.add(small);
        cinemaHallService.add(medium);
        cinemaHallService.add(large);

        MovieSession one = new MovieSession();
        one.setMovie(movieService.get(1L));
        one.setCinemaHall(cinemaHallService.get(1L));
        one.setShowTime(LocalDateTime.now().plusHours(1));

        MovieSession two = new MovieSession();
        two.setMovie(movieService.get(2L));
        two.setCinemaHall(cinemaHallService.get(2L));
        two.setShowTime(LocalDateTime.now().plusHours(2));

        MovieSession three = new MovieSession();
        three.setMovie(movieService.get(3L));
        three.setCinemaHall(cinemaHallService.get(3L));
        three.setShowTime(LocalDateTime.now().plusHours(3));

        movieSessionService.add(one);
        movieSessionService.add(two);
        movieSessionService.add(three);

        movieService.getAll().forEach(x -> System.out.println(x));
        cinemaHallService.getAll().forEach(x -> System.out.println(x));
        movieSessionService.getAll().forEach(x -> System.out.println(x));
    }
}
