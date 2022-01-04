package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.request.MovieSessionRequestDto;
import mate.academy.spring.dto.response.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionMapper;
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
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionMapper movieSessionMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapper movieSessionMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @GetMapping("/available")
    @ResponseStatus(HttpStatus.OK)
    public List<MovieSessionResponseDto> getAvailable(
            @RequestParam Long movieId, @RequestParam @DateTimeFormat(
                    pattern = "dd.MM.yyyy") LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date)
                .stream()
                .map(movieSessionMapper::map)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieSessionResponseDto add(@RequestBody MovieSessionRequestDto dto) {
        MovieSession movieSession = movieSessionService.add(movieSessionMapper.unmap(dto));
        return movieSessionMapper.map(movieSession);
    }

    @PutMapping("/{movieSessionId}")
    @ResponseStatus(HttpStatus.OK)
    public MovieSessionResponseDto update(
            @PathVariable Long movieSessionId, @RequestBody MovieSessionRequestDto dto) {
        MovieSession movieSession = movieSessionMapper.unmap(dto);
        movieSession.setId(movieSessionId);
        return movieSessionMapper.map(movieSessionService.update(movieSession));
    }

    @DeleteMapping("/{movieSessionId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long movieSessionId) {
        movieSessionService.remove(movieSessionService.get(movieSessionId));
    }
}
