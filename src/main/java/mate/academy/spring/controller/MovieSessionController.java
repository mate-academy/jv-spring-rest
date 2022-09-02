package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieSessionController {
    public static final String DATE_FORMAT = "dd.MM.yyyy";
    private final MovieSessionService movieSessionService;
    private final MovieSessionDtoMapper movieSessionDtoMapper;

    @Autowired
    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionDtoMapper movieSessionDtoMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionDtoMapper = movieSessionDtoMapper;
    }

    @PostMapping("/movie-sessions")
    @ResponseStatus(HttpStatus.CREATED)
    private MovieSessionResponseDto create(@RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        return movieSessionDtoMapper.parse(movieSessionService
                .add(movieSessionDtoMapper.toModel(movieSessionRequestDto)));
    }

    @GetMapping("/movie-sessions/available")
    @ResponseBody
    private List<MovieSessionResponseDto> getAvailableSessions(@RequestParam Long movieId,
                            @RequestParam @DateTimeFormat(pattern = DATE_FORMAT) LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(movieSessionDtoMapper::parse)
                .collect(Collectors.toList());
    }

    @PutMapping("/movie-sessions/{id}")
    @ResponseBody
    private MovieSessionResponseDto update(@PathVariable Long id,
                                   @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = movieSessionDtoMapper.toModel(movieSessionRequestDto);
        movieSession.setId(id);
        movieSession = movieSessionService.update(movieSession);
        return movieSessionDtoMapper.parse(movieSession);
    }

    @DeleteMapping("/movie-sessions/{id}")
    @ResponseBody
    private boolean delete(@PathVariable Long id) {
        return movieSessionService.delete(id);
    }
}
