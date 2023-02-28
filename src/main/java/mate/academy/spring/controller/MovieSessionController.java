package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionDtoMapper;
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
    public final MovieSessionService movieSessionService;
    public final MovieSessionDtoMapper movieSessionDtoMapper;

    public MovieSessionController(MovieSessionService movieSessionService, MovieSessionDtoMapper movieSessionDtoMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionDtoMapper = movieSessionDtoMapper;
    }

    @PostMapping
    public MovieSessionResponseDto create(@RequestBody MovieSessionRequestDto movieSession) {
        return movieSessionDtoMapper.parse(movieSessionService
                .add(movieSessionDtoMapper.toModel(movieSession)));
    }

    @GetMapping
    public List<MovieSessionResponseDto> getAllMovieSession() {
        return movieSessionService.getAll().stream()
                .map(movieSessionDtoMapper::parse)
                .collect(Collectors.toList());
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> findAllAvailableSessions(
            @RequestParam Long movieId,
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(movieSessionDtoMapper::parse)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        MovieSession movieSession = movieSessionService.get(id);
        movieSessionService.delete(movieSession);
    }

    @PutMapping("{/id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody MovieSessionRequestDto requestDto) {
        MovieSession movieSession = movieSessionDtoMapper.toModel(requestDto);
        movieSession.setId(id);
        MovieSession updatedMovieSession = movieSessionService.update(movieSession);
        return movieSessionDtoMapper.parse(updatedMovieSession);
    }
}
