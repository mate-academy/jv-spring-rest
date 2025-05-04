package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.MovieSessionRequestMapper;
import mate.academy.spring.mapper.MovieSessionResponseMapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
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
    private final MovieSessionRequestMapper movieSessionRequestMapper;
    private final MovieSessionResponseMapper movieSessionResponseMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionRequestMapper movieSessionRequestMapper,
                                  MovieSessionResponseMapper movieSessionResponseMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionRequestMapper = movieSessionRequestMapper;
        this.movieSessionResponseMapper = movieSessionResponseMapper;

    }

    @PostMapping
    public MovieSessionResponseDto add(@RequestBody MovieSessionRequestDto dto) {
        MovieSession movieSession = movieSessionService.add(movieSessionRequestMapper.fromDto(dto));
        return movieSessionResponseMapper.toDto(movieSession);
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> findAvailableSessions(
                                        @RequestParam Long movieId,
                                        @RequestParam
                                        @DateTimeFormat(pattern = "dd.MM.yyyy")
                                        LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(movieSessionResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody MovieSessionRequestDto dto) {
        MovieSession movieSession = movieSessionRequestMapper.fromDto(dto);
        movieSession.setId(id);
        movieSessionService.update(movieSession);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }
}
