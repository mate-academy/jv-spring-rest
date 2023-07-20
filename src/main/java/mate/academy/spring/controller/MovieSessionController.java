package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionDtoMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies-sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionDtoMapper movieSessionDtoMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionDtoMapper movieSessionDtoMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionDtoMapper = movieSessionDtoMapper;
    }

    @GetMapping("/available")
    @ResponseStatus(HttpStatus.OK)
    public List<MovieSessionResponseDto> findAllAvailable(
            @RequestParam Long movieId,
            @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date)
                .stream()
                .map(movieSessionDtoMapper::parse)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieSessionResponseDto add(MovieSessionRequestDto movieSessionRequestDto) {
        return movieSessionDtoMapper
                .parse(movieSessionService
                        .add(movieSessionDtoMapper
                                .toModel(movieSessionRequestDto)));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MovieSessionResponseDto update(
            @PathVariable Long id,
            @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession newSession = movieSessionDtoMapper.toModel(movieSessionRequestDto);
        newSession.setId(id);
        MovieSession updated = movieSessionService.update(newSession);
        return movieSessionDtoMapper.parse(updated);
    }

    @DeleteMapping("movie-sessions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody Long id) {
        movieSessionService.remove(movieSessionService.get(id));
    }
}
