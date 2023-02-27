package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.mapper.MovieSessionMapper;
import mate.academy.spring.model.MovieSession;
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
    private final MovieSessionMapper movieSessionMapper;
    private final MovieSessionService movieSessionService;

    public MovieSessionController(MovieSessionMapper movieSessionMapper,
                                  MovieSessionService movieSessionService) {
        this.movieSessionMapper = movieSessionMapper;
        this.movieSessionService = movieSessionService;
    }

    @PostMapping
    public MovieSessionResponseDto add(MovieSessionRequestDto requestDto) {
        return movieSessionMapper
                .toDto(movieSessionService.add(movieSessionMapper.toModel(requestDto)));
    }

    @GetMapping("/available/{movieId}")
    public List<MovieSessionResponseDto> getAvailable(@RequestParam Long movieId,
                                                      @RequestParam @DateTimeFormat
                                                              (pattern = "dd.MM.yyyy")
                                                      LocalDate showTime) {
        return movieSessionService.findAvailableSessions(movieId, showTime).stream()
                .map(movieSessionMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody MovieSessionRequestDto requestDto) {
        MovieSession movieSession = movieSessionMapper.toModel(requestDto);
        movieSession.setId(id);
        MovieSession updatedMovieSession = movieSessionService.update(movieSession);
        return movieSessionMapper.toDto(updatedMovieSession);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        MovieSession movieSession = movieSessionService.get(id);
        movieSessionService.delete(movieSession);
    }
}
