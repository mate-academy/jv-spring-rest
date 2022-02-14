package mate.academy.spring.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionDtoMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    /*
    Add movie session - POST: /movie-sessions
    Get all available movie sessions - GET: /movie-sessions/available?movieId=1&date=29.02.2020
    Update movie session - PUT /movie-sessions/{id}
    Remove movie session - DELETE /movie-sessions/{id}
     */
    private MovieSessionService movieSessionService;
    private MovieSessionDtoMapper movieSessionDtoMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionDtoMapper movieSessionDtoMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionDtoMapper = movieSessionDtoMapper;
    }

    @PostMapping
    public MovieSessionResponseDto create(@RequestBody MovieSessionRequestDto movieSession) {
        return movieSessionDtoMapper.parse(movieSessionService.add(movieSessionDtoMapper
                .toModel(movieSession)));
    }

    @GetMapping("/")
    public List<MovieSessionResponseDto> getAllMovieSessions(@PathVariable Long movieId,
                                                             LocalDateTime date) {
        return movieSessionService.findAvailableSessions(movieId, LocalDate.from(date)).stream()
                .map(movieSessionDtoMapper::parse)
                .collect(Collectors.toList());
    }

    @PutMapping("{/id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody MovieSessionRequestDto requestDto) {
        MovieSession movieSession = movieSessionDtoMapper.toModel(requestDto);
        movieSession.setId(id);
        MovieSession updateMovieSession = movieSessionService.update(movieSession);
        return movieSessionDtoMapper.parse(updateMovieSession);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }
}
