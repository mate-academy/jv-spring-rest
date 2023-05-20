package mate.academy.spring.controller;

import mate.academy.spring.dto.movieSession.MovieSessionRequestDto;
import mate.academy.spring.dto.movieSession.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionDtoMapper movieSessionDtoMapper;

    @Autowired
    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionDtoMapper movieSessionDtoMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionDtoMapper = movieSessionDtoMapper;
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> movieSessions(@RequestParam Long id,
                                                       @RequestParam @DateTimeFormat
                                                               (pattern = "dd.MM.yyyy") LocalDate showTime) {
        List<MovieSession> availableSessions = movieSessionService.findAvailableSessions(id, showTime);
        return availableSessions.stream()
                .map(movieSessionDtoMapper::parseMovieSession)
                .collect(Collectors.toList());
    }

    @PostMapping()
    public MovieSessionResponseDto create(@RequestBody MovieSessionRequestDto movieSessionRequestDto,
                                          @RequestBody @RequestParam @DateTimeFormat
                                                  (pattern = "dd.MM.yyyy") LocalDate showTime) {
        MovieSession movieSessionModel = movieSessionDtoMapper.toModel(movieSessionRequestDto, showTime);
        MovieSession MovieSessionFromDb = movieSessionService.add(movieSessionModel);
        return movieSessionDtoMapper.parseMovieSession(MovieSessionFromDb);
    }
}
