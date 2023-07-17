package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.MovieRequestMapper;
import mate.academy.spring.mapper.MovieResponseMapper;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import mate.academy.spring.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieRequestMapper movieRequestMapper;
    private final MovieResponseMapper movieResponseMapper;

    public MovieController(MovieService movieService,
                           MovieRequestMapper movieRequestMapper,
                           MovieResponseMapper movieResponseMapper) {
        this.movieService = movieService;
        this.movieRequestMapper = movieRequestMapper;
        this.movieResponseMapper = movieResponseMapper;
    }

    @GetMapping
    public List<MovieResponseDto> get() {
        return movieService.getAll().stream()
                .map(movieResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping
    public MovieResponseDto add(@RequestBody MovieRequestDto movieRequestDto) {
        return movieResponseMapper.toDto(movieService
                .add(movieRequestMapper.fromDto(movieRequestDto)));
    }
}
