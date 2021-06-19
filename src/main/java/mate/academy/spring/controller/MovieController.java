package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    @Autowired
    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @PostMapping
    public MovieResponseDto add(@RequestBody MovieRequestDto movieRequestDto) {
        return movieMapper.mapToDto(movieService
                .add(movieMapper.toModel(movieRequestDto)));
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll().stream()
                .map(movieMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/inject")
    public String injectMovies() {
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
        return "Added mock movies to DB!";
    }
}
