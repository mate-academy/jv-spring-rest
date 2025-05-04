package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.mapper.MovieDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movies")
public class MovieController {
    private final MovieDtoMapper movieDtoMapper;
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieDtoMapper movieDtoMapper, MovieService movieService) {
        this.movieDtoMapper = movieDtoMapper;
        this.movieService = movieService;
    }

    @PostMapping
    public MovieResponseDto create(@RequestBody MovieRequestDto requestDto) {
        return movieDtoMapper.toDto(movieService.add(movieDtoMapper.toModel(requestDto)));
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll()
                .stream()
                .map(movieDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
