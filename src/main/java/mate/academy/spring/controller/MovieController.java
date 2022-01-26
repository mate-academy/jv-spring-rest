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
    private final MovieDtoMapper movieDtoMapper;
    private final MovieService movieService;

    public MovieController(MovieDtoMapper dtoMapper, MovieService movieService) {
        this.movieDtoMapper = dtoMapper;
        this.movieService = movieService;
    }

    @PostMapping
    public MovieResponseDto add(@RequestBody MovieRequestDto dto) {
        return movieDtoMapper.parse(movieService.add(movieDtoMapper.toModel(dto)));
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll().stream()
                                    .map(movieDtoMapper::parse)
                                    .collect(Collectors.toList());
    }
}
