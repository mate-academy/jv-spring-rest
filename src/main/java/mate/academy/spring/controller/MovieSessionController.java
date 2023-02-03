package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequest;
import mate.academy.spring.model.dto.MovieSessionResponse;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.maper.MovieSessionMapper;
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
    private static final String DATE_FORMAT = "dd.MM.yyyy";
    private final MovieSessionService movieSessionService;
    private final MovieSessionMapper movieSessionMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapper movieSessionMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @PostMapping
    public MovieSessionResponse create(@RequestBody MovieSessionRequest movieSessionRequest) {
        return movieSessionMapper.toDto(movieSessionService
                .add(movieSessionMapper.toModel(movieSessionRequest)));
    }

    @GetMapping("/available")
    public List<MovieSessionResponse> getAllAvailable(
            @RequestParam Long id,
            @RequestParam @DateTimeFormat(pattern = DATE_FORMAT) LocalDate localDate) {
        return movieSessionService.findAvailableSessions(id, localDate).stream()
                .map(movieSessionMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody MovieSessionRequest movieSessionRequest) {
        MovieSession movieSession = movieSessionMapper.toModel(movieSessionRequest);
        movieSession.setId(id);
        movieSessionService.update(movieSession);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }
}
