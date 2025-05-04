package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.mapper.MovieDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieDtoMapper dtoMapper;

    public MovieController(MovieService movieService, MovieDtoMapper dtoMapper) {
        this.movieService = movieService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll().stream()
                .map(dtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public MovieResponseDto add(@RequestBody MovieRequestDto movieDto) {
        return dtoMapper.toDto(movieService.add(dtoMapper.toModel(movieDto)));
    }
}

