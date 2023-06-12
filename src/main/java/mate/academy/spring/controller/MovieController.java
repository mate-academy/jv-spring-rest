package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper mapper;

    @Autowired
    public MovieController(MovieService movieService, MovieMapper mapper) {
        this.movieService = movieService;
        this.mapper = mapper;
    }

    @PostMapping("/movies")
    public MovieResponseDto add(@RequestBody MovieRequestDto movie) {
        return mapper.toDto(movieService.add(mapper.toModel(movie)));
    }

    @GetMapping("/movies")
    public List<MovieResponseDto> getAll() {
        return movieService.getAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
