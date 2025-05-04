package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.request.MovieRequestDto;
import mate.academy.spring.model.dto.response.MovieResponseDto;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.mapper.MovieMapper;
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
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieResponseDto add(@RequestBody MovieRequestDto movieRequestDto) {
        return movieMapper.toResponseDto(movieService.add(
                movieMapper.toModel(movieRequestDto)
        ));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MovieResponseDto> getAll() {
        return movieService.getAll().stream()
                .map(movieMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
