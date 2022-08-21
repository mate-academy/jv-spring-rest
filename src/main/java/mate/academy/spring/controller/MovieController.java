package mate.academy.spring.controller;

import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.model.Movie;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.mapper.CinemaHallDtoMapper;
import mate.academy.spring.service.mapper.MovieDtoMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MovieController {
    private MovieService movieService;
    private MovieResponseDto movieResponseDto;
    private MovieRequestDto movieRequestDto;
    private MovieDtoMapper movieDtoMapper;

    public MovieController(MovieService movieService,
                           MovieResponseDto movieResponseDto,
                           MovieRequestDto movieRequestDto,
                           MovieDtoMapper movieDtoMapper) {
        this.movieService = movieService;
        this.movieResponseDto = movieResponseDto;
        this.movieRequestDto = movieRequestDto;
        this.movieDtoMapper = movieDtoMapper;
    }

    @PostMapping("/movies")
    @ResponseBody
    private MovieResponseDto create(@RequestBody MovieRequestDto movieRequestDto) {
        return movieDtoMapper.parse(movieService.add(movieDtoMapper.toModel(movieRequestDto)));
    }

    @GetMapping("/movies")
    @ResponseBody
    private List<MovieResponseDto> getAll() {
        return movieService.getAll().stream()
                .map(movieDtoMapper::parse)
                .collect(Collectors.toList());
    }
}
