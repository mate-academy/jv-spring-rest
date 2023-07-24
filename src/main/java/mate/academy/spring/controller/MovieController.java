package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.movie.MovieRequestDto;
import mate.academy.spring.dto.movie.MovieResponseDto;
import mate.academy.spring.mapper.MovieDtoMapper;
import mate.academy.spring.model.Movie;
import mate.academy.spring.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieDtoMapper mapper;

    public MovieController(MovieService movieService, MovieDtoMapper mapper) {
        this.movieService = movieService;
        this.mapper = mapper;
    }

    @PostMapping
    public MovieResponseDto create(@RequestBody MovieRequestDto movieRequestDto) {
        Movie movie = mapper.toModel(movieRequestDto);
        return mapper.toDto(movie);
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        List<Movie> movies = movieService.getAll();
        return movies.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
