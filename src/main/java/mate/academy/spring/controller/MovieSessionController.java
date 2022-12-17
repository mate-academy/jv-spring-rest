package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionMapper;
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
    private MovieSessionService movieSessionService;
    private MovieSessionMapper movieSessionMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapper movieSessionMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @PostMapping("/movie-sessions")
    public MovieSessionResponseDto create(
            @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        return movieSessionMapper.parseFromModelToResponseDto(movieSessionService
                .add(movieSessionMapper.parseFromRequestDtoToModel(movieSessionRequestDto)));
    }

    @GetMapping("/movie-sessions/available")
    public List<MovieSessionResponseDto> get(@RequestParam Long movieId,
                         @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate showTime) {
        return movieSessionService.findAvailableSessions(movieId, showTime).stream()
                .map(movieSessionMapper::parseFromModelToResponseDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/movie-sessions/{movieSessionId}")
    public MovieSessionResponseDto update(@PathVariable Long movieSessionId,
                                      @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession
                = movieSessionMapper.parseFromRequestDtoToModel(movieSessionRequestDto);
        movieSession.setId(movieSessionId);
        return movieSessionMapper
                .parseFromModelToResponseDto(movieSessionService.update(movieSession));
    }

    @DeleteMapping("/movie-sessions/{movieSessionId}")
    public void delete(@PathVariable Long movieSessionId) {
        movieSessionService.delete(movieSessionId);
    }
}
