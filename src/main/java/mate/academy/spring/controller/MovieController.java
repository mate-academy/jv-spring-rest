package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import mate.academy.spring.service.MovieMapper;
import mate.academy.spring.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService service;
    private final MovieMapper mapper;

    public MovieController(MovieService service, MovieMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public MovieResponseDto createMovie(@RequestBody MovieRequestDto movieRequestDto) {
        return mapper.parse(service.add(mapper.toModel(movieRequestDto)));
    }

    @GetMapping
    public List<MovieResponseDto> getAllMovie() {
        return service.getAll()
                .stream()
                .map(mapper::parse)
                .collect(Collectors.toList());
    }
}
