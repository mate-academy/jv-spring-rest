package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.movies.session.MovieSessionRequestDto;
import mate.academy.spring.dto.movies.session.MovieSessionResponseDto;
import mate.academy.spring.mapper.MovieSessionDtoMapper;
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
    private final MovieSessionService movieSessionService;
    private final MovieSessionDtoMapper mapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionDtoMapper mapper) {
        this.movieSessionService = movieSessionService;
        this.mapper = mapper;
    }

    @PostMapping
    public MovieSessionResponseDto create(
            @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = mapper.toModel(movieSessionRequestDto);
        return mapper.toDto(movieSessionService.add(movieSession));
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAllAvailable(
            @RequestParam Long movieId,
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody MovieSessionRequestDto requestDto) {
        MovieSession movieSession = mapper.toModel(requestDto);
        movieSession.setId(id);
        MovieSession updatedMovieSession = movieSessionService.update(movieSession);
        return mapper.toDto(updatedMovieSession);
    }
}
