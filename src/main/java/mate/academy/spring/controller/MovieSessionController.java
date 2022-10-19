package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionMapperService;
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
    private MovieSessionMapperService mapperService;
    private MovieSessionService movieSessionService;

    public MovieSessionController(MovieSessionMapperService mapperService,
                                  MovieSessionService movieSessionService) {
        this.mapperService = mapperService;
        this.movieSessionService = movieSessionService;
    }

    @PostMapping
    public MovieSessionResponseDto add(@RequestParam MovieSessionRequestDto
                                                           movieSessionRequestDto) {
        return mapperService.toDto(movieSessionService.add(
                mapperService.toModel(movieSessionRequestDto)));
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(
            @PathVariable Long id,
            @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = mapperService.toModel(movieSessionRequestDto);
        movieSession.setId(id);
        return mapperService.toDto(movieSessionService.update(movieSession));
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id,
                       @RequestParam MovieSessionRequestDto
                                           movieSessionRequestDto) {
        MovieSession movieSession = mapperService.toModel(movieSessionRequestDto);
        movieSession.setId(id);
        movieSessionService.remove(movieSession);
    }

    @GetMapping("/available/{movieId}&{date}")
    public List<MovieSessionResponseDto> getAvailableMovieSession(
            @RequestParam Long movieId, @RequestParam
            @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(ms -> mapperService.toDto(ms))
                .collect(Collectors.toList());
    }
}
