package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.mapper.MovieDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private MovieService movieService;
    private MovieDtoMapper movieDtoMapper;

    public MovieController(MovieService movieService,
                           MovieDtoMapper movieDtoMapper) {
        this.movieService = movieService;
        this.movieDtoMapper = movieDtoMapper;
    }

    @GetMapping()
    public List<MovieResponseDto> getAllMovies() {
        return movieService.getAll().stream()
                .map(movieDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping()
    public MovieResponseDto create(MovieRequestDto movieRequestDto) {
        Movie movie = movieDtoMapper.toModel(movieRequestDto);
        return movieDtoMapper.toDto(movieService.add(movie));
    }
}
