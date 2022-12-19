package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final MovieSessionDtoMapper movieSessionDtoMapper;

    @Autowired
    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionDtoMapper movieSessionDtoMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionDtoMapper = movieSessionDtoMapper;
    }

    @PostMapping("/movie-sessions")
    public MovieSessionResponseDto add(@RequestBody MovieSessionRequestDto requestDto) {
        return movieSessionDtoMapper
                .parse(movieSessionService.add(movieSessionDtoMapper.toModel(requestDto)));
    }

    @GetMapping("/movie-sessions/available")
    public List<MovieSession> findAvailable(
            @RequestParam(name = "movieId") Long id,
            @RequestParam(name = "date") @DateTimeFormat(
                    pattern = "dd.MM.yyyy") LocalDate localDate) {
        return movieSessionService.findAvailableSessions(id, localDate);
    }

    @PutMapping("movie-sessions/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody MovieSessionRequestDto requestDto) {
        MovieSession movieSession = movieSessionDtoMapper.toModel(requestDto);
        movieSession.setId(id);
        MovieSession updatedMovieSession = movieSessionService.update(movieSession);
        return movieSessionDtoMapper.parse(updatedMovieSession);
    }

    @DeleteMapping("/movie-sessions/{id}")
    public void remove(@PathVariable Long id) {
        movieSessionService.delete(movieSessionService.get(id));
    }
}
