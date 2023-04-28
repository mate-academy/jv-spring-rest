package mate.academy.spring.controller;

import java.util.List;
import mate.academy.spring.dto.request.MovieRequestDto;
import mate.academy.spring.dto.responce.MovieResponseDto;
import mate.academy.spring.mapper.Mapper;
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
    private final Mapper<MovieRequestDto, Movie> requestMapper;
    private final Mapper<Movie, MovieResponseDto> responseMapper;

    public MovieController(MovieService movieService,
                           Mapper<MovieRequestDto, Movie> requestMapper,
                           Mapper<Movie, MovieResponseDto> responseMapper) {
        this.movieService = movieService;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    @PostMapping
    public MovieResponseDto add(@RequestBody MovieRequestDto dto) {
        return responseMapper.map(movieService.add(requestMapper.map(dto)));
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return responseMapper.mapAll(movieService.getAll());
    }
}
