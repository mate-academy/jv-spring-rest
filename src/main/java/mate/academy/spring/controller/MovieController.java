package mate.academy.spring.controller;

import java.util.List;
import mate.academy.spring.model.Movie;
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
    private final MovieDtoMapper movieDtoMapper;

    public MovieController(MovieService movieService,
                           MovieDtoMapper movieDtoMapper) {
        this.movieService = movieService;
        this.movieDtoMapper = movieDtoMapper;
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll()
                .stream()
                .map(movieDtoMapper::toDto)
                .toList();
    }

    @PostMapping
    public MovieResponseDto create(@RequestBody MovieRequestDto movieRequestDto) {
        Movie movie =
                movieService.add(movieDtoMapper.toModel(movieRequestDto));
        return movieDtoMapper.toDto(movie);
    }
}
