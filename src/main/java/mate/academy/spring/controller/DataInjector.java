package mate.academy.spring.controller;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        Movie harryPotterPartOne = new Movie("Harry Potter and the philosopher's stone");
        harryPotterPartOne.setDescription("Harry Potter and the Philosopher's Stone is an "
                + "enthralling start to Harry's journey toward coming to terms with his past "
                + "and facing his future");
        movieService.add(harryPotterPartOne);

        Movie harryPotterPartTwo = new Movie("Harry Potter and the chamber of secrets description");
        harryPotterPartTwo.setDescription("The plot follows Harry's second year at Hogwarts"
                + " School of Witchcraft and Wizardry, during which a series of messages on the"
                + " walls of the school's corridors warn that the \"Chamber of Secrets\" has"
                + " been opened.");
        movieService.add(harryPotterPartTwo);

        Movie harryPotterPartThree = new Movie("Harry Potter and the prisoner of azkaban");
        harryPotterPartThree.setDescription("Harry Potter, a young wizard, in his third year at"
                + " Hogwarts School of Witchcraft and Wizardry. Along with friends Ronald "
                + "Weasley and Hermione Granger,Harry investigates Sirius Black, an escaped"
                + " prisoner from Azkaban, the wizard prison,"
                + " believed to be one of Lord Voldemort's old allies.");
        movieService.add(harryPotterPartThree);

        Movie harryPotterPartFour = new Movie("Harry Potter and the goblet of fire");
        harryPotterPartFour.setDescription("It follows Harry Potter, a wizard in his fourth "
                + "year at Hogwarts School of Witchcraft and Wizardry, and the mystery surrounding"
                + " the entry of Harry's name into the Triwizard Tournament, in which he is forced"
                + " to compete. ");

        CinemaHall bigCinemaHall = new CinemaHall();
        bigCinemaHall.setCapacity(300);
        bigCinemaHall.setDescription("Big cinema hall with IMAX");
        cinemaHallService.add(bigCinemaHall);

        CinemaHall regularCinemaHall = new CinemaHall();
        regularCinemaHall.setCapacity(200);
        regularCinemaHall.setDescription("Regular cinema hall with big screen");
        cinemaHallService.add(regularCinemaHall);

        CinemaHall smallCinemaHall = new CinemaHall();
        smallCinemaHall.setCapacity(100);
        smallCinemaHall.setDescription("Small cinema hall with small screen");
        cinemaHallService.add(smallCinemaHall);
        return "Added mock data DB!";
    }
}
