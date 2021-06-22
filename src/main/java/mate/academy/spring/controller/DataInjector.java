package mate.academy.spring.controller;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/inject")
public class DataInjector {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    @Autowired
    public DataInjector(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    @GetMapping
    public String injectData() {
        Movie cruella = new Movie("Cruella");
        cruella.setDescription("A live-action prequel feature film following"
                + " a young Cruella de Vil.");
        movieService.add(cruella);

        Movie tomAndJerry = new Movie("Tom and Jerry");
        tomAndJerry.setDescription("A chaotic battle ensues between Jerry Mouse, "
                + "who has taken refuge in the Royal Gate Hotel, and Tom Cat, who "
                + "is hired to drive him away before the day of a big wedding arrives.");
        movieService.add(tomAndJerry);

        CinemaHall salon = new CinemaHall();
        salon.setCapacity(50);
        salon.setDescription("Stylish cinema hall with comfortable seats.");
        cinemaHallService.add(salon);

        return "Data is injected";
    }
}
