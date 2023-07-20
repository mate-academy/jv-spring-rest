package mate.academy.spring.controller;

import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.mapper.MovieMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieController {
    private MovieService movieService;
    private MovieMapper movieMapper;

    @GetMapping("/movies")
    public MovieRequestDto add() {

    }

    @GetMapping("/movies")
    public List<MovieResponseDto> getAll() {
        return movieService.getAll().stream()
                .map(m -> movieMapper.parseToResp(m))
                .collect(Collectors.toList());
    }
}
