package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.mapper.MovieMapper;
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
    public MovieResponseDto add(@RequestBody MovieRequestDto requestDto) {
        return mapper.toDto(service.add(mapper.toModel(requestDto)));
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return service.getAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
