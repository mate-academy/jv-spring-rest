package mate.academy.spring.controller;

import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.mapper.MovieDtoMapper;
import mate.academy.spring.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
public class MovieController {
    MovieService movieService;
    MovieDtoMapper movieDtoMapper;

    public MovieController (MovieService movieService, MovieDtoMapper movieDtoMapper) {
        this.movieService = movieService;
        this.movieDtoMapper = movieDtoMapper;
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll().stream().map(movieDtoMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping
    public MovieResponseDto create (@RequestBody MovieRequestDto movieRequestDto) {
        return movieDtoMapper.toDto(movieService.add(movieDtoMapper.toModel(movieRequestDto)));
    }
}
