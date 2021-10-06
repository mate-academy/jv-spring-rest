package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import jdk.jfr.Registered;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionMapper movieSessionMapper;

    @Autowired
    public MovieSessionController(MovieSessionService movieSessionService, MovieSessionMapper movieSessionMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAllAvailableMovieSessions(
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date,
            @RequestParam Long movieId) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(movieSessionMapper::parse)
                .collect(Collectors.toList());
    }

    @PostMapping
    public MovieSessionResponseDto create(@RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        return movieSessionMapper.parse(movieSessionService.add(
                movieSessionMapper.toModel(movieSessionRequestDto)));
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) {
        movieSessionService.get(id);
    }

    @PutMapping("{/id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = movieSessionMapper.toModel(movieSessionRequestDto);
        movieSession.setId(id);
        MovieSession updatedMovieSession =
                movieSessionService.update(movieSession);
        return movieSessionMapper.parse(updatedMovieSession);
    }
}
