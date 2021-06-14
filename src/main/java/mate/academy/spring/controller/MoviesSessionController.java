package mate.academy.spring.controller;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies-sessions")
public class MoviesSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionMapper movieSessionMapper;

    public MoviesSessionController(MovieSessionService movieSessionService,
                                   MovieSessionMapper movieSessionMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAvailableSessions(
            @RequestParam Long id,
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return movieSessionService.findAvailableSessions(id, date).stream()
                .map(movieSessionMapper::parseIntoDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public MovieSessionResponseDto add(@RequestBody MovieSessionRequestDto requestDto) {
        return movieSessionMapper.parseIntoDto(movieSessionService
                .add(movieSessionMapper.parseFromDto(requestDto)));
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody MovieSessionRequestDto requestDto) {
        MovieSession movieSession = movieSessionMapper.parseFromDto(requestDto);
        movieSession.setId(id);
        return movieSessionMapper.parseIntoDto(movieSessionService.update(movieSession));
    }

    @DeleteMapping("/{id}")
    void remove(@PathVariable Long id) {
        movieSessionService.remove(id);
    }
}
