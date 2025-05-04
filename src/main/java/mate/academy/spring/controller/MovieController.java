package mate.academy.spring.controller;

import java.util.List;
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
    private final MovieService service;
    private final MovieDtoMapper mapper;

    public MovieController(MovieService movieService, MovieDtoMapper movieDtoMapper) {
        this.service = movieService;
        this.mapper = movieDtoMapper;
    }

    @PostMapping
    public MovieResponseDto create(@RequestBody MovieRequestDto reqDto) {
        return mapper.toDto(service.add(mapper.toModel(reqDto)));
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return service.getAll().stream()
                .map(mapper::toDto)
                .toList();
    }
}
