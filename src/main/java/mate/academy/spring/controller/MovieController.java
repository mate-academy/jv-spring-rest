package mate.academy.spring.controller;

import java.util.List;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import mate.academy.spring.model.dto.mapper.MovieMapper;
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
    private final MovieMapper movieMapper;

    public MovieController(MovieService movieService, MovieMapper mapper) {
        this.movieService = movieService;
        this.movieMapper = mapper;
    }

    @GetMapping
    public List<MovieResponseDto> getAllMovies() {
        return movieService.getAll()
                .stream()
                .map(movieMapper::toDto)
                .toList();
    }

    @PostMapping
    public MovieResponseDto create(@RequestBody MovieRequestDto dto) {
        return movieMapper.toDto(movieService.add(movieMapper.toModel(dto)));
    }
}

