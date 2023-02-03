package mate.academy.spring.controller;

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

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie-session")
public class MovieSessionController {
    public final MovieSessionService movieSessionService;

    public final MovieSessionMapper movieSessionMapper;

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
            @RequestBody Long id,
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate localDate) {
        return movieSessionService.findAvailableSessions(id, localDate).stream()
                .map(movieSessionMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody MovieSessionRequest movieSessionRequest) {
        movieSessionService.update(id, movieSessionMapper.toModel(movieSessionRequest));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }
}
