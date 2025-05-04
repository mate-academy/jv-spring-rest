package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
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

    @GetMapping("/available")
    public List<MovieSessionResponseDto> findAvailableSessions(
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy")
            LocalDate date, @RequestParam Long movieId) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(movieSessionMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public MovieSessionResponseDto create(@RequestBody
                                              MovieSessionRequestDto movieSessionRequestDto) {
        return movieSessionMapper.toDto(movieSessionService
                .add(movieSessionMapper.toModel(movieSessionRequestDto)));
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id, @RequestBody
                                                MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = movieSessionMapper.toModel(movieSessionRequestDto);
        movieSession.setId(id);
        movieSessionService.update(movieSession);
        return movieSessionMapper.toDto(movieSession);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }
}
