package mate.academy.spring.controller;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inject")
public class InjectController {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    @Autowired
    public InjectController(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    @GetMapping()
    public String injectData() {
        Movie fastAndFurious = new Movie("Fast and Furious");
        fastAndFurious.setDescription("An action film about street racing, heists, and spies.");
        movieService.add(fastAndFurious);

        Movie trolls = new Movie("trolls");
        trolls.setDescription("Simple funny");
        movieService.add(trolls);

        Movie harryPotter = new Movie("Tron: Legacy");
        harryPotter.setDescription("About boy!");
        movieService.add(harryPotter);

        CinemaHall expensive3D = new CinemaHall();
        expensive3D.setCapacity(50);
        expensive3D.setDescription("with 3D");
        cinemaHallService.add(expensive3D);

        CinemaHall poor3D = new CinemaHall();
        poor3D.setCapacity(50);
        poor3D.setDescription("without 3D");
        cinemaHallService.add(poor3D);
        return "All were injected!";
    }
}
