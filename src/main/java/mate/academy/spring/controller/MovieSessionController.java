package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.RequestMovieSessionDto;
import mate.academy.spring.dto.ResponseMovieSessionDto;
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
    private final MovieSessionService movieSessionService;
    private final MovieSessionMapper movieSessionMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapper movieSessionMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @PostMapping
    public ResponseMovieSessionDto create(
            @RequestBody RequestMovieSessionDto requestMovieSessionDto) {
        MovieSession movieSession = movieSessionMapper.toModel(requestMovieSessionDto);
        return movieSessionMapper.toDto(movieSessionService.add(movieSession));
    }

    @GetMapping("/available")
    public List<ResponseMovieSessionDto> findAvailable(
            @RequestParam Long movieId,
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(movieSessionMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ResponseMovieSessionDto update(
            @PathVariable Long id,
            @RequestBody RequestMovieSessionDto requestMovieSessionDto) {
        MovieSession updatedMovieSession = movieSessionMapper.toModel(requestMovieSessionDto);
        updatedMovieSession.setId(id);
        return movieSessionMapper.toDto(movieSessionService.update(updatedMovieSession));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }
}
