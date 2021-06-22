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
        Movie fastAndFurious = new Movie("Fast and Furious");
        fastAndFurious.setDescription("An action film about street racing, heists, and spies.");
        movieService.add(fastAndFurious);

        Movie interstellar = new Movie("Interstellar");
        interstellar.setDescription("When Earth becomes uninhabitable in the future, "
                + "a farmer and ex-NASA pilot, Joseph Cooper, is tasked to pilot a spacecraft, "
                + "along with a team of researchers, to find a new planet for humans.");
        movieService.add(interstellar);

        Movie tronLegacy = new Movie("Tron: Legacy");
        tronLegacy.setDescription("Sam misses his father, a virtual world designer, "
                + "and enters a virtual space that has become much "
                + "more dangerous than his father intended. Now, both "
                + "father and son embark upon a life-and-death journey.");
        movieService.add(tronLegacy);

        Movie inception = new Movie("Inception");
        inception.setDescription("Cobb steals information from his targets by entering "
                + "their dreams. Saito offers to wipe clean Cobb's criminal history "
                + "as payment for performing an inception on his sick competitor's son.");

        CinemaHall redCinemaHall = new CinemaHall();
        redCinemaHall.setCapacity(50);
        redCinemaHall.setDescription("Red cinema hall with comfy armchairs");
        cinemaHallService.add(redCinemaHall);

        CinemaHall greenCinemaHall = new CinemaHall();
        greenCinemaHall.setCapacity(50);
        greenCinemaHall.setDescription("Green cinema hall with big screen");
        cinemaHallService.add(greenCinemaHall);

        CinemaHall blueCinemaHall = new CinemaHall();
        blueCinemaHall.setCapacity(70);
        blueCinemaHall.setDescription("blue cinema hall with comfy armchairs, big screen and IMAX");
        cinemaHallService.add(blueCinemaHall);
        return "Added mock data DB!";
    }
}
