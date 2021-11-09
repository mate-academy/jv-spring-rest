package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionMapper;
import mate.academy.spring.service.mapper.SupportMapper;
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
    private final MovieSessionMapper mapper;
    private final SupportMapper supportMapper;

    @Autowired
    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapper mapper, SupportMapper supportMapper) {
        this.movieSessionService = movieSessionService;
        this.mapper = mapper;
        this.supportMapper = supportMapper;
    }

    @GetMapping("/movie-sessions/available")
    public List<MovieSessionResponseDto> find(@RequestParam Long movieId,
                                              @RequestParam
                                              @DateTimeFormat(pattern = "dd.MM.yyyy")
                                                      LocalDate date) {
        return mapper.movieSessionListToResponseDtoList(
                movieSessionService.findAvailableSessions(movieId, date));
    }

    @PostMapping("/movie-sessions")
    public MovieSessionResponseDto create(@RequestBody MovieSessionRequestDto dto) {
        return mapper.movieSessionToMovieSessionResponseDto(movieSessionService
                .add(supportMapper.movieSessionRequestDtoToMovieSession(dto)));
    }

    @PutMapping("/movie-sessions/{id}")
    public void update(@PathVariable Long id, @RequestBody MovieSessionRequestDto dto) {
        MovieSession movieSession = supportMapper.movieSessionRequestDtoToMovieSession(dto);
        movieSession.setId(id);
        movieSessionService.update(movieSession);
    }

    @DeleteMapping("/movie-sessions/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }
}
