package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.mapper.MovieMapperDto;
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
    private final MovieMapperDto movieMapperDto;

    @Autowired
    public MovieController(MovieService movieService, MovieMapperDto movieMapperDto) {
        this.movieService = movieService;
        this.movieMapperDto = movieMapperDto;
    }

    @PostMapping
    public MovieResponseDto create(@RequestBody MovieRequestDto requestDto) {
        return movieMapperDto.toDto(movieService.add(movieMapperDto.toModel(requestDto)));
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll()
                .stream().map(movieMapperDto::toDto)
                .collect(Collectors.toList());
    }
}
