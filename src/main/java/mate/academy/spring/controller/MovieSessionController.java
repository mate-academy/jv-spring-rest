package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieSessionRequest;
import mate.academy.spring.dto.MovieSessionResponse;
import mate.academy.spring.mapper.MovieSessionMapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionMapper movieSessionMapper;

    @Autowired
    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapper movieSessionMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @GetMapping
    public MovieSessionResponse add(MovieSessionRequest movieSessionRequest) {
        return movieSessionMapper.parse(movieSessionService
                .add(movieSessionMapper.toModel(movieSessionRequest)));
    }

    @GetMapping("/avaliable")
    List<MovieSessionResponse> get(@RequestParam @DateTimeFormat (pattern = "dd.MM.yyyy")
                                   LocalDate time, @RequestParam Long movieId) {
        return movieSessionService.findAvailableSessions(movieId, time)
                .stream().map(m -> movieSessionMapper.parse(m)).collect(Collectors.toList());

    }

    @PutMapping("/{id}")
    public MovieSessionResponse update(@PathVariable Long id,
                                       @RequestParam MovieSessionRequest movieSessionRequest) {
        MovieSession movieSession = movieSessionMapper.toModel(movieSessionRequest);
        movieSession.setId(id);
        return movieSessionMapper.parse(movieSessionService.update(movieSession));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }
}
