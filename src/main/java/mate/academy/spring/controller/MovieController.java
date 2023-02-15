package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.impl.MovieMapperImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieMapperImpl movieMapper;
    private final MovieService movieService;

    public MovieController(MovieMapperImpl movieMapper, MovieService movieService) {
        this.movieMapper = movieMapper;
        this.movieService = movieService;
    }

    @PostMapping
    public MovieResponseDto createMovie(@RequestBody MovieRequestDto movieRequestDto) {
        return movieMapper
                .toDto(movieService.add(new Movie()));
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService
                .getAll()
                .stream()
                .map(movieMapper::toDto)
                .collect(Collectors.toList());
    }
}
