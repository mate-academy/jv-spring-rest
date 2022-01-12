package mate.academy.spring.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.dto.MovieSessionDtoMapper;
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
    private final MovieSessionService movieSessionService;
    private final MovieSessionDtoMapper movieSessionMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                          MovieSessionDtoMapper movieSessionMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAvailable(
            @RequestParam Long movieId, @RequestParam @DateTimeFormat(
                    pattern = "dd.MM.yyyy") LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date)
                .stream()
                .map(movieSessionMapper::parse)
                .collect(Collectors.toList());
    }

    @PostMapping
    public MovieSessionResponseDto add(@RequestBody MovieSessionRequestDto dto) {
        MovieSession movieSession = movieSessionService.add(movieSessionMapper.toModel(dto));
        return movieSessionMapper.parse(movieSession);
    }

    @PutMapping("/{movieSessionId}")
    public MovieSessionResponseDto update(
            @PathVariable Long movieSessionId, @RequestBody MovieSessionRequestDto dto) {
        MovieSession movieSession = movieSessionMapper.toModel(dto);
        movieSession.setId(movieSessionId);
        return movieSessionMapper.parse(movieSessionService.update(movieSession));
    }

    @DeleteMapping("/{movieSessionId}")
    public void delete(@PathVariable Long movieSessionId) {
        movieSessionService.remove(movieSessionService.get(movieSessionId));
    }
}
