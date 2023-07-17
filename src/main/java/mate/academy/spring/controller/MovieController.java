package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.request.MovieRequestDto;
import mate.academy.spring.model.dto.response.MovieResponseDto;
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
    private final MovieDtoMapper mapper;

    public MovieController(MovieService movieService, MovieDtoMapper mapper) {
        this.movieService = movieService;
        this.mapper = mapper;
    }

    @PostMapping
    public MovieResponseDto add(@RequestBody MovieRequestDto movieRequestDto) {
        return mapper.toDto(movieService.add(mapper.toModel(movieRequestDto)));
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
