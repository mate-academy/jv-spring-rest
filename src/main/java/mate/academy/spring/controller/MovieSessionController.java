package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
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
    private final MovieSessionMapper movieSessionMapper;
    private final MovieSessionService movieSessionService;

    public MovieSessionController(MovieSessionMapper movieSessionMapper,
                                  MovieSessionService movieSessionService) {
        this.movieSessionMapper = movieSessionMapper;
        this.movieSessionService = movieSessionService;
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> findAvailableMovieSessions(
            @RequestParam Long movieId,
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return movieSessionMapper.findAvailableMovieSessions(movieId, date);
    }

    @PostMapping
    public MovieSessionResponseDto addMovieSession(
            @RequestBody MovieSessionRequestDto requestDto) {
        return movieSessionMapper.parse(
                movieSessionService.add(movieSessionMapper.toModel(requestDto)));
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto updateMovieSession(
            @PathVariable Long id,
            @RequestBody MovieSessionRequestDto requestDto) {
        return movieSessionMapper.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }

}
