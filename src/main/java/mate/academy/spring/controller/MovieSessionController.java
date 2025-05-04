package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.dto.mapper.MovieSessionMapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService sessionService;
    private final MovieSessionMapper sessionMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapper movieSessionMapper) {
        this.sessionService = movieSessionService;
        this.sessionMapper = movieSessionMapper;
    }

    @PostMapping
    public MovieSessionResponseDto add(@RequestBody MovieSessionRequestDto sessionRequestDto) {
        return sessionMapper.toDto(sessionService
                .add(sessionMapper.toModel(sessionRequestDto)));
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> findAvailableSessions(@PathVariable Long movieId,
                                                               @RequestParam
                                                               @DateTimeFormat
                                                                       (pattern = "dd.MM.yyyy")
                                                               LocalDate date) {
        return sessionService.findAvailableSessions(movieId, date).stream()
                .map(sessionMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody MovieSessionRequestDto sessionRequestDto) {
        MovieSession movieSession = sessionMapper.toModel(sessionRequestDto);
        movieSession.setId(id);
        MovieSession updateMovieSession = sessionService.update(movieSession);
        return sessionMapper.toDto(updateMovieSession);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sessionService.delete(sessionService.get(id));
    }
}
