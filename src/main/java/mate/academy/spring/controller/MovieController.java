package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.MovieDtoMapper;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
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
    private final MovieService movieService;
    private final MovieDtoMapper mapper;

    @Autowired
    public MovieController(MovieService movieService, MovieDtoMapper mapper) {
        this.movieService = movieService;
        this.mapper = mapper;
    }

    @PostMapping
    public MovieResponseDto create(@RequestBody MovieRequestDto requestDto) {
        return mapper.toDto(movieService.add(mapper.toModel(requestDto)));
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
