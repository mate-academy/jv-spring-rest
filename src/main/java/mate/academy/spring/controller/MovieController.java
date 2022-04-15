package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.mapper.MovieDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieDtoMapper movieDtoMapper;
    private final MovieService movieService;
    
    public MovieController(MovieDtoMapper movieDtoMapper, MovieService movieService) {
        this.movieDtoMapper = movieDtoMapper;
        this.movieService = movieService;
    }
    
    @PostMapping
    public MovieResponseDto add(MovieRequestDto movie) {
        return movieDtoMapper.parse(movieDtoMapper.toModel(movie));
    }
    
    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll().stream().map(movieDtoMapper::parse)
                .collect(Collectors.toList());
    }
}
