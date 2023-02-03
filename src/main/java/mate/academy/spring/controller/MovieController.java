package mate.academy.spring.controller;

import mate.academy.spring.model.dto.MovieRequest;
import mate.academy.spring.model.dto.MovieResponse;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.maper.MovieMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie")
public class MovieController {
    public final MovieService movieService;
    public final MovieMapper movieMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @PostMapping
    public MovieResponse create(@RequestBody MovieRequest movieRequest) {
        return movieMapper.toDto(movieService.add(movieMapper.toModel(movieRequest)));
    }

    @GetMapping
    public List<MovieResponse> getAll() {
        return movieService.getAll().stream()
                .map(movieMapper::toDto)
                .collect(Collectors.toList());
    }
}
