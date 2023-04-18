package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieRequest;
import mate.academy.spring.dto.MovieResponse;
import mate.academy.spring.mapper.MovieMapper;
import mate.academy.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public List<MovieResponse> getAll() {
        return movieService.getAll().stream()
                .map(m -> movieMapper.parse(m)).collect(Collectors.toList());
    }

    @PostMapping
    public MovieResponse add(@RequestBody MovieRequest movieRequest) {
        return movieMapper.parse(movieService.add(movieMapper.toModel(movieRequest)));
    }
}
