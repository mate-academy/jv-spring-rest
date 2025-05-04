package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionMapper;
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
    private MovieSessionService sessionService;
    private MovieSessionMapper sessionMapper;

    public MovieSessionController(MovieSessionService sessionService,
                                  MovieSessionMapper sessionMapper) {
        this.sessionService = sessionService;
        this.sessionMapper = sessionMapper;
    }

    @PostMapping
    public MovieSessionResponseDto create(@RequestBody
                                              MovieSessionRequestDto movieSessionRequestDto) {
        return sessionMapper.toDto(sessionService.add(sessionMapper
                .toModel(movieSessionRequestDto)));
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                       @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = sessionMapper.toModel(movieSessionRequestDto);
        movieSession.setId(id);
        sessionService.update(movieSession);
        return sessionMapper.toDto(movieSession);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sessionService.delete(sessionService.get(id));
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAllAvailableMovieSessions(
            @RequestParam Long movieId,
             @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return sessionService.findAvailableSessions(movieId, date).stream()
                .map(s -> sessionMapper.toDto(s))
                .collect(Collectors.toList());
    }
}
