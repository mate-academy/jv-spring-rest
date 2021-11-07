package mate.academy.spring.controller;

import mate.academy.spring.mapper.MovieSessionDtoMapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionDtoMapper movieSessionDtoMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionDtoMapper movieSessionDtoMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionDtoMapper = movieSessionDtoMapper;
    }

    @PostMapping
    public MovieSessionResponseDto create(@RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        return movieSessionDtoMapper.toDto(movieSessionService
                .add(movieSessionDtoMapper.toModel(movieSessionRequestDto)));
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAllAvailable(@RequestParam Long movieId, @RequestParam
    @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date)
                .stream()
                .map(movieSessionDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id, @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = movieSessionDtoMapper.toModel(movieSessionRequestDto);
        movieSession.setId(id);
        return movieSessionDtoMapper.toDto(movieSessionService.update(movieSession));
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        movieSessionService.remove(id);
    }
}
