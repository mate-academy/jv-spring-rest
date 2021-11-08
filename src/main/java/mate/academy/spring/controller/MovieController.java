package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieRequestDto;
import mate.academy.spring.dto.MovieResponseDto;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.mapper.MovieMapperDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private MovieService moviesService;
    private MovieMapperDto mapperDto;

    public MovieController(MovieService moviesService, MovieMapperDto mapperDto) {
        this.moviesService = moviesService;
        this.mapperDto = mapperDto;
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return moviesService.getAll().stream()
                .map(mapperDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public MovieResponseDto create(@RequestBody MovieRequestDto req) {
        return mapperDto.toDto(moviesService.add(mapperDto.toModel(req)));
    }
}
