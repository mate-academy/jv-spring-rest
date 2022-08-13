package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.mapper.MovieDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    private final MovieService movieService;
    private final MovieDtoMapper movieDtoMapper;

    public MovieController(MovieService movieService,
                           MovieDtoMapper movieDtoMapper) {
        this.movieService = movieService;
        this.movieDtoMapper = movieDtoMapper;
    }

    @PostMapping("/movies")
    public MovieResponseDto create(@RequestBody MovieRequestDto requestDto) {
        return movieDtoMapper.toDto(
                movieService.add(movieDtoMapper.toModel(requestDto)));
    }

    @GetMapping("/movies")
    public List<MovieResponseDto> getAll() {
        return movieService.getAll()
                .stream()
                .map(movieDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
