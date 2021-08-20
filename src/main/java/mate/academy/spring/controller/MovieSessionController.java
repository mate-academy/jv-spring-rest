package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.MovieSession;
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
    private MovieSessionService movieSessionService;
    private MovieSessionMapper movieSessionMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapper movieSessionMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @PostMapping
    public MovieSessionResponseDto addMovieSession(
            @RequestBody MovieSessionRequestDto requestDto) {
        return movieSessionMapper.parse(movieSessionService.add(
                movieSessionMapper.parseToModel(requestDto)
        ));
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAvailable(@RequestParam Long movieId,
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(movieSessionMapper::parse)
                .collect(Collectors.toList());
    }

    @PutMapping("${id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
            @RequestBody MovieSessionRequestDto requestDto) {
        MovieSessionResponseDto responseDto = new MovieSessionResponseDto();
        MovieSession update = movieSessionService
                .update(movieSessionMapper.parseToModel(requestDto));
        return movieSessionMapper.parse(update);
    }

    @DeleteMapping("${id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }
}
