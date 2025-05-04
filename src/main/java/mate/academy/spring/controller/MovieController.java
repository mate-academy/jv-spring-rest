package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.MovieDtoRequest;
import mate.academy.spring.model.dto.MovieDtoResponse;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.mapper.MovieDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieDtoMapper movieDtoMapper;
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieDtoMapper movieDtoMapper, MovieService movieService) {
        this.movieDtoMapper = movieDtoMapper;
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieDtoResponse> getAll() {
        return movieService.getAll()
                .stream()
                .map(movieDtoMapper::parse)
                .collect(Collectors.toList());
    }

    @PostMapping
    public MovieDtoResponse create(@RequestBody MovieDtoRequest movieDtoRequest) {
        return movieDtoMapper.parse(movieService.add(movieDtoMapper.toModel(movieDtoRequest)));
    }
}
