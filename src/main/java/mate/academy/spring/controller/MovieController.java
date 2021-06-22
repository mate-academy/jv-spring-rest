package mate.academy.spring.controller;

import mate.academy.spring.service.MovieService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public MovieResponseDto create(@RequestBody MovieRequestDto movieRequestDto) {
        return null;
    }

    public List<MovieResponseDto> getAll() {
        return null;
    }
}
