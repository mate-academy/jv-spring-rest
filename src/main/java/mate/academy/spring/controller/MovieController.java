package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.dto.MovieRequestDto;
import mate.academy.spring.service.dto.MovieResponseDto;
import mate.academy.spring.service.mappers.MovieMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private MovieService movieService;
    private MovieMapper movieMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieResponseDto addMovie(@RequestBody MovieRequestDto movieRequestDto) {
        return movieMapper.parseEntityToDto(movieService
                .add(movieMapper.parseDtoToEntity(movieRequestDto)));
    }

    @GetMapping
    public List<MovieResponseDto> getAllMovies() {
        return movieService.getAll()
                .stream()
                .map(movieMapper::parseEntityToDto)
                .collect(Collectors.toList());
    }
}
