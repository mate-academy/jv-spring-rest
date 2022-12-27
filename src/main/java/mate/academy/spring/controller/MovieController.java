package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.movie.MovieRequestDto;
import mate.academy.spring.dto.movie.MovieResponseDto;
import mate.academy.spring.mapper.MovieMapper;
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
    private MovieMapper movieMapper;

    @Autowired
    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @PostMapping
    public MovieResponseDto add(@RequestBody
                                MovieRequestDto movieRequestDto) {
        return movieMapper.toDto(movieMapper.toModel(movieRequestDto));
    }

    @GetMapping("")
    public List<MovieResponseDto> getAll() {
        return movieService.getAll().stream()
                .map(movieMapper::toDto)
                .collect(Collectors.toList());
    }
}
