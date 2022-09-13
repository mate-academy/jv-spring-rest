package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.moviesession.MovieSessionRequestDto;
import mate.academy.spring.model.dto.moviesession.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionMapper;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieSessionResponseDto create(
            @RequestBody MovieSessionRequestDto movieSessionDto) {
        MovieSession movieSession = movieSessionMapper.toModel(movieSessionDto);
        return movieSessionMapper.toDto(movieSessionService.add(movieSession));
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAll(
            @RequestParam Long movieId, LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(movieSessionMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(
            @PathVariable Long id, @RequestBody MovieSessionRequestDto movieSessionDto) {
        MovieSession movieSession = movieSessionMapper.toModel(movieSessionDto);
        movieSession.setId(id);
        return movieSessionMapper.toDto(movieSessionService.update(movieSession));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }
}
