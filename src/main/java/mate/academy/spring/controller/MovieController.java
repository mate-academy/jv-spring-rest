package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.mapper.MovieRequestMapper;
import mate.academy.spring.mapper.MovieResponseMapper;
import mate.academy.spring.model.Movie;
import mate.academy.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private MovieService movieService;
    private MovieRequestMapper requestMapper;
    private MovieResponseMapper responseMapper;

    @Autowired
    public MovieController(MovieService movieService,
                           MovieRequestMapper requestMapper,
                           MovieResponseMapper responseMapper) {
        this.movieService = movieService;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    @PostMapping
    public MovieResponseDto add(@RequestBody MovieRequestDto movieRequestDto) {
        Movie movie = movieService.add(requestMapper.toModel(movieRequestDto));
        return responseMapper.toDto(movie);
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll()
                .stream()
                .map(responseMapper::toDto)
                .collect(Collectors.toList());
    }
}
