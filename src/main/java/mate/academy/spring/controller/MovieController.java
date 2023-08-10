package mate.academy.spring.controller;

import mate.academy.spring.dto.movie.MovieRequestDto;
import mate.academy.spring.dto.movie.MovieResponseDto;
import mate.academy.spring.model.mapper.MovieMapper;
import mate.academy.spring.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @PostMapping("/movies")
    public MovieResponseDto create(@RequestBody MovieRequestDto requestDto) {
        return movieMapper.parse(movieService.add(movieMapper.toModel(requestDto)));
    }

    @GetMapping("/movies")
    public List<MovieResponseDto> getAllMovies() {
        return movieService.getAll().stream().map(movieMapper::parse).collect(Collectors.toList());
    }
}
