package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.request.MovieRequestDto;
import mate.academy.spring.dto.response.MovieResponseDto;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Movie;
import mate.academy.spring.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movies")
public class MovieController {
    private final MovieService movieService;
    private final DtoResponseMapper<Movie, MovieResponseDto> responseDtoMapper;
    private final DtoRequestMapper<Movie, MovieRequestDto> requestDtoMapper;

    public MovieController(MovieService movieService,
                           DtoResponseMapper<Movie, MovieResponseDto> responseDtoMapper,
                           DtoRequestMapper<Movie, MovieRequestDto> requestDtoMapper) {
        this.movieService = movieService;
        this.responseDtoMapper = responseDtoMapper;
        this.requestDtoMapper = requestDtoMapper;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public MovieResponseDto add(@RequestBody MovieRequestDto dto) {
        Movie movie = movieService.add(requestDtoMapper.toModel(dto));
        return responseDtoMapper.toDto(movie);
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll().stream()
                .map(responseDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
