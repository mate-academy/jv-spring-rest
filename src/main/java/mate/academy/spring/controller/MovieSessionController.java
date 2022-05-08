package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieSessionDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.transformer.MovieSessionTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/movie-sessions")
public class MovieSessionController {

    private final MovieSessionService movieSessionService;
    private final MovieSessionTransformer movieSessionTransformer;

    @Autowired
    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionTransformer movieSessionTransformer) {
        this.movieSessionService = movieSessionService;
        this.movieSessionTransformer = movieSessionTransformer;
    }

    @PostMapping
    public void add(@RequestBody MovieSessionDto movieSessionDto) {
        MovieSession movieSession = movieSessionTransformer.formFromDto(movieSessionDto);
        movieSessionService.add(movieSession);
    }

    @GetMapping("/available")
    public List<MovieSessionDto> getAvailable(@RequestParam Long movieId,
                                              @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date)
            .stream()
            .map(movieSessionTransformer::toDto)
            .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void updateMovieSession(@PathVariable Long id,
                                   @RequestBody MovieSessionDto movieSession) throws Exception {
        movieSessionService.update(id, movieSessionTransformer.formFromDto(movieSession));
    }

    @DeleteMapping("/{id}")
    public void deleteMovieSession(@PathVariable Long id) {
        movieSessionService.delete(id);
    }
}
