package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.moviesession.MovieSessionRequestDto;
import mate.academy.spring.dto.moviesession.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
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
    private final MovieSessionMapper sessionMapper;
    private final MovieSessionService sessionService;

    public MovieSessionController(MovieSessionMapper sessionMapper,
                                  MovieSessionService sessionService) {
        this.sessionMapper = sessionMapper;
        this.sessionService = sessionService;
    }

    @PostMapping("")
    public MovieSessionResponseDto create(@RequestBody MovieSessionRequestDto requestDto) {
        MovieSession movieSession = sessionMapper.toModel(requestDto);
        MovieSession addedSession = sessionService.add(movieSession);
        return sessionMapper.toDto(addedSession);
    }

    @GetMapping(value = "/available")
    public List<MovieSessionResponseDto> findAllAvailableSessions(@RequestParam Long movieId,
                                                            @RequestParam @DateTimeFormat
                                                                    (pattern = "dd.MM.yyyy")
                                                            LocalDate date) {
        return sessionService.findAvailableSessions(movieId, date)
                .stream()
                .map(sessionMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody MovieSessionRequestDto requestDto) {
        MovieSession movieSession = sessionMapper.toModel(requestDto);
        movieSession.setId(id);
        MovieSession updatedSession = sessionService.update(movieSession);
        return sessionMapper.toDto(updatedSession);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sessionService.delete(id);
    }
}
