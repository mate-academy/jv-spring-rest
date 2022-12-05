package mate.academy.spring.controller;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieSessionDto;
import mate.academy.spring.dto.mapper.impl.MovieSessionMapper;
import mate.academy.spring.exception.MovieSessionNotFoundException;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
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
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("movie-sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionMapper movieSessionMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapper movieSessionMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public MovieSessionDto add(@RequestBody MovieSessionDto dto) {
        try {
            MovieSession movieSession = movieSessionService.add(movieSessionMapper.toModel(dto));
            return movieSessionMapper.toDto(movieSession);
        } catch (DateTimeParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Can't create movie session: "
                    + "Invalid showTime format: " + dto.getShowTime(), e);
        }
    }

    @GetMapping("/available")
    public List<MovieSessionDto> getAllAvailableSessions(
            @RequestParam
            Long movieId,
            @RequestParam
            @DateTimeFormat(pattern = "dd.MM.yyyy")
            LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date)
                .stream()
                .map(movieSessionMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody
                       MovieSessionDto dto) {
        try {
            MovieSession movieSession = movieSessionService.get(id);
            movieSessionService.update(movieSession);
        } catch (NoSuchElementException e) {
            throw new MovieSessionNotFoundException(
                    "Can't find movie session by id " + id, e);
        } catch (DateTimeParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Can't create movie session: "
                            + "Invalid showTime format: " + dto.getShowTime(), e);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        try {
            MovieSession movieSession = movieSessionService.get(id);
            movieSessionService.delete(movieSession);
        } catch (NoSuchElementException e) {
            throw new MovieSessionNotFoundException(
                    "Can't find movie session by id " + id, e);
        }
    }
}
