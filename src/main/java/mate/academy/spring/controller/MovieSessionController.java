package mate.academy.spring.controller;

import mate.academy.spring.mapper.MovieMapper;
import mate.academy.spring.mapper.MovieSessionMapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.request.MovieRequestDto;
import mate.academy.spring.model.dto.request.MovieSessionRequestDto;
import mate.academy.spring.model.dto.response.MovieResponseDto;
import mate.academy.spring.model.dto.response.MovieSessionResponseDto;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionMapper movieSessionMapper;

    public MovieSessionController(MovieSessionService movieService, MovieSessionMapper movieSessionMapper) {
        this.movieSessionService = movieService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAllAvailable(@RequestParam Long movieId
            ,@RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return movieSessionService
                .findAvailableSessions(movieId, date)
                .stream()
                .map(movieSessionMapper::parse)
                .collect(Collectors.toList());
    }

    @PostMapping
    public MovieSessionResponseDto create(@RequestBody MovieSessionRequestDto requestDto) {
        return movieSessionMapper
                .parse(movieSessionService
                        .add(movieSessionMapper.toModel(requestDto)));
    }
}

