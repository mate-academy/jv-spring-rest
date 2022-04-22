package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.mapper.MovieSessionMapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapper movieSessionMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @PostMapping// /movie-sessions
    public MovieSessionResponseDto addMS(@RequestBody MovieSessionRequestDto requestDto) {
        MovieSession movieSession = movieSessionService.add(
                movieSessionMapper.dtoToModel(requestDto));
        return movieSessionMapper.modelToDto(movieSession);
    }

    @GetMapping("/available") // /movie-sessions/available?movieId=1&date=29.02.2020
    public List<MovieSessionResponseDto> getAllAvailableMS(@RequestParam Long movieId,
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(movieSessionMapper::modelToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}") // /movie-sessions/{id}
    public MovieSession updateMS(@PathVariable Long id,
                                 @RequestBody MovieSessionRequestDto requestDto) {
        MovieSession movieSession = movieSessionMapper.dtoToModel(requestDto);
        movieSession.setId(id);
        return movieSessionService.update(movieSession);
    }

    @DeleteMapping("/id") // /movie-sessions/{id}
    public void deleteMS(@PathVariable Long id) {
        movieSessionService.delete(movieSessionService.get(id));
    }
}
