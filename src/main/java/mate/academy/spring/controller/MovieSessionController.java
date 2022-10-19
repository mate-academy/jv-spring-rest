package mate.academy.spring.controller;

import mate.academy.spring.dto.responses.MovieSessionDtoResponse;
import mate.academy.spring.dto.requests.MovieSessionDtoRequest;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionDtoMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
public class MovieSessionController {
    private MovieSessionService movieSessionService;
    private MovieSessionDtoMapper movieSessionDtoMapper;

    public MovieSessionController(MovieSessionService movieSessionService, MovieSessionDtoMapper movieSessionDtoMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionDtoMapper = movieSessionDtoMapper;
    }

    @PostMapping
    public MovieSessionDtoResponse create(MovieSessionDtoRequest movieSessionDtoRequest) {
        return movieSessionDtoMapper.parse(movieSessionService.add(movieSessionDtoMapper.toModel(movieSessionDtoRequest)));
    }

    @GetMapping("/available")
    public List<MovieSessionDtoResponse> findAvailableMovieSessions(@RequestParam Long movieId,
                                                                    @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate showTime) {
       return movieSessionService.findAvailableSessions(movieId, showTime)
                .stream()
                .map(movieSessionDtoMapper::parse)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public MovieSessionDtoResponse delete(@PathVariable Long id) {
        return movieSessionDtoMapper.parse(movieSessionService.delete(movieSessionService.get(id)));
    }

    @PutMapping("/{id}")
    public MovieSessionDtoResponse update(@PathVariable Long id,
                                          @RequestParam MovieSessionDtoRequest movieSessionDtoRequest) {
        MovieSession movieSession = movieSessionDtoMapper.toModel(movieSessionDtoRequest);
        movieSession.setId(id);
        return movieSessionDtoMapper.parse(movieSession);
    }
}
