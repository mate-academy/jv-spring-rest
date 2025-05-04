package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.requests.MovieDtoRequest;
import mate.academy.spring.dto.responses.MovieDtoResponse;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.mapper.MovieDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return movieDtoMapper.toDto(movieService.add(movieDtoMapper.toModel(movieDtoRequest)));
    }

    @GetMapping
    public List<MovieDtoResponse> getAllMovies() {
        return movieService.getAll()
                .stream()
                .map(movieDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
