package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
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

    private MovieService movieService;
    private MovieDtoMapper movieDtoMapper;

    @PostMapping
    public MovieResponseDto addMovie(@RequestBody MovieRequestDto movieRequestDto) {
        return movieDtoMapper.modelInDto(movieService
                .add(movieDtoMapper.dtoInModel(movieRequestDto)));
    }

    @GetMapping("/all")
    public List<MovieResponseDto> allMovie() {
        return movieService.getAll().stream()
              .map(movieDtoMapper::modelInDto)
              .collect(Collectors.toList());
    }
}
