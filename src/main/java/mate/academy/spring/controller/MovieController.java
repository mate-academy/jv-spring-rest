package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieMapper movieMapper;
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieMapper movieMapper,
                           MovieService movieService) {
        this.movieMapper = movieMapper;
        this.movieService = movieService;
    }

    @PostMapping
    public MovieResponseDto addDto(@RequestBody MovieRequestDto requestDto) {
        return movieMapper.toDto(movieService.add(movieMapper.toModel(requestDto)));
    }

    @GetMapping("/")
    public List<MovieResponseDto> getAll() {
        return movieService.getAll()
                .stream()
                .map(movieMapper::toDto)
                .collect(Collectors.toList());
    }
}
