package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.movie.MovieRequestDto;
import mate.academy.spring.dto.movie.MovieResponseDto;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.mapper.MovieMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private MovieService movieService;
    private MovieMapper mapper;

    public MovieController(MovieService movieService, MovieMapper mapper) {
        this.movieService = movieService;
        this.mapper = mapper;
    }

    @PostMapping
    public MovieResponseDto create(@RequestBody MovieRequestDto movieRequestDto) {
        return mapper.toDto(movieService.add(mapper.toModel(movieRequestDto)));
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
