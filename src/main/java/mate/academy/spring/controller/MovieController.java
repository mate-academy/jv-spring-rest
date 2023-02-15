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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private MovieDtoMapper mapper;
    private MovieService service;

    public MovieController(MovieDtoMapper mapper, MovieService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping
    public List<MovieResponseDto> getAllMovies() {
        return service.getAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @PostMapping
    public MovieResponseDto create(@RequestBody MovieRequestDto movieRequestDto) {
        return mapper.toDto(service.add(mapper.toModel(movieRequestDto)));
    }
}
