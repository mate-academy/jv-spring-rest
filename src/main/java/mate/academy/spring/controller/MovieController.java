package mate.academy.spring.controller;

import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.model.Movie;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.mapper.MovieDtoMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieDtoMapper movieDtoMapper;


    public MovieController(MovieService movieService, MovieDtoMapper movieDtoMapper) {
        this.movieService = movieService;
        this.movieDtoMapper = movieDtoMapper;
    }

    @PostMapping
    public MovieResponseDto addMovie(@RequestBody MovieRequestDto movieRequestDto) {
        Movie movieFromDto = movieDtoMapper.toModel(movieRequestDto);
        Movie movieFromDB = movieService.add(movieFromDto);
        return movieDtoMapper.parse(movieFromDB);
    }

    @GetMapping
    public List<MovieResponseDto> getAllMovies() {
        return movieService.getAll().stream()
                .map(movieDtoMapper::parse)
                .collect(Collectors.toList());
    }
}
