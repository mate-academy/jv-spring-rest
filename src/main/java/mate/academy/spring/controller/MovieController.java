package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.responses.MovieDtoResponse;
import mate.academy.spring.dto.requests.MovieDtoRequest;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.mapper.MovieDtoMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie-sessions")
public class MovieController {
    private MovieDtoMapper movieDtoMapper;
    private MovieService movieService;

    public MovieController(MovieDtoMapper movieDtoMapper, MovieService movieService) {
        this.movieDtoMapper = movieDtoMapper;
        this.movieService = movieService;
    }

    @PostMapping
    public MovieDtoResponse create(@RequestBody MovieDtoRequest movieDtoRequest) {
        return movieDtoMapper.parse(movieService.add(movieDtoMapper.toModel(movieDtoRequest)));
    }

    @GetMapping
    public List<MovieDtoResponse> getAllMovies() {
        return movieService.getAll()
                .stream()
                .map(movieDtoMapper::parse)
                .collect(Collectors.toList());
    }
}

