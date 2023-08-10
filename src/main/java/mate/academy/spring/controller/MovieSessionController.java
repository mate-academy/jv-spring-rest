package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.movie.session.MovieSessionRequestDto;
import mate.academy.spring.dto.movie.session.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.mapper.MovieSessionMapper;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionMapper movieSessionMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapper movieSessionMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @PostMapping("/movie-sessions")
    public MovieSessionResponseDto create(@RequestBody MovieSessionRequestDto requestDto) {
        return movieSessionMapper.toDto(movieSessionService
            .add(movieSessionMapper.toModel(requestDto)));
    }

    @PutMapping("/movie-sessions/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody MovieSessionRequestDto requestDto) {
        MovieSession session = movieSessionMapper.toModel(requestDto);
        session.setId(id);
        movieSessionService.update(session);
        return movieSessionMapper.toDto(movieSessionService.get(id));
    }

    @DeleteMapping("/movie-sessions/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(movieSessionService.get(id));
    }

    @GetMapping("/movie-sessions/available")
    public List<MovieSessionResponseDto> getAllAvailable(@RequestParam Long id,
                                                         @RequestParam
                                                         @DateTimeFormat(pattern = "dd.MM.yyyy")
                                                         LocalDate date) {
        return movieSessionService.findAvailableSessions(id, date)
                .stream().map(movieSessionMapper::toDto)
                .collect(Collectors.toList());
    }
}
