package mate.academy.spring.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.security.mapper.MovieSessionDtoMapper;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionDtoMapper movieSessionDtoMapper;
    private final MovieSessionService movieSessionService;

    public MovieSessionController(MovieSessionDtoMapper movieSessionDtoMapper,
                                  MovieSessionService movieSessionService) {
        this.movieSessionDtoMapper = movieSessionDtoMapper;
        this.movieSessionService = movieSessionService;
    }

    @GetMapping
    public MovieSessionResponseDto add(@RequestBody MovieSessionRequestDto movieRequestDto) {
        return movieSessionDtoMapper.parse(movieSessionService
                .add(movieSessionDtoMapper.toMovieSession(movieRequestDto)));
    }

    @GetMapping(path = "/available")
    public List<MovieSessionResponseDto> get(@RequestParam Long id, @RequestParam @DateTimeFormat
            (pattern = "dd.MM.yyyy") LocalDate date) {
        return movieSessionService
                .findAvailableSessions(id, date)
                .stream()
                .map(movieSessionDtoMapper::parse)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody MovieSessionRequestDto movieRequestDto) {
        MovieSession movieSession = movieSessionDtoMapper.toMovieSession(movieRequestDto);
        movieSession.setId(id);
        MovieSession updatedMovieSession = movieSessionService.update(movieSession);
        return movieSessionDtoMapper.parse(updatedMovieSession);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(movieSessionService.get(id));
    }

    @GetMapping("/inject")
    public String create() {
        MovieSession movieSession = new MovieSession();
        Movie movie = new Movie();
        movie.setTitle("Frozen");
        movie.setDescription("Some description");
        movieSession.setMovie(movie);
        movieSession.setShowTime(LocalDateTime.now());
        return "Done";
    }
}

