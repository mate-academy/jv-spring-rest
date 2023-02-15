package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.model.Movie;
import mate.academy.spring.service.DtoMapper;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final DtoMapper<Movie, MovieRequestDto, MovieResponseDto> dtoMapper;

    public MovieController(MovieService movieService,
                           @Qualifier("movieMapper")
                           MovieMapper movieMapper) {
        this.movieService = movieService;
        this.dtoMapper = movieMapper;
    }

    @PostMapping
    public MovieResponseDto create(@RequestBody MovieRequestDto movieRequestDto) {
        return dtoMapper.toDto(movieService.add(dtoMapper.toModel(movieRequestDto)));
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll().stream()
                .map(dtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
