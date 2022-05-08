package mate.academy.spring.controller;

import mate.academy.spring.dto.MovieDto;
import mate.academy.spring.model.Movie;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.transformer.MovieTransformer;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/movies")
public class MovieController {

    private final MovieService movieService;
    private final MovieTransformer movieTransformer;

    @Autowired
    public MovieController(MovieService movieService, MovieTransformer movieTransformer) {
        this.movieService = movieService;
        this.movieTransformer = movieTransformer;
    }

    @PostMapping
    public void add(@RequestBody MovieDto movieDto) {
        Movie movie = movieTransformer.fromDto(movieDto);
        movieService.add(movie);
    }

    @GetMapping
    public List<MovieDto> getAll() {
        return movieService.getAll()
            .stream()
            .map(movieTransformer::toDto)
            .collect(Collectors.toList());
    }
}
