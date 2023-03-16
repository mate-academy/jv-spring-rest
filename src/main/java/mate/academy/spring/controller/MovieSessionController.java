package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/movieSessions")
@RestController
public class MovieSessionController {
    private final MovieService movieService;

    private final CinemaHallService cinemaHallService;
    private final MovieSessionService movieSessionService;
    private final MovieSessionDtoMapper movieSessionDtoMapper;

    @Autowired
    public MovieSessionController(MovieService movieService,
                                  CinemaHallService cinemaHallService,
                                  MovieSessionService movieSessionService,
                                  MovieSessionDtoMapper movieSessionDtoMapper) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
        this.movieSessionService = movieSessionService;
        this.movieSessionDtoMapper = movieSessionDtoMapper;
    }

    @GetMapping
    public List<MovieSessionResponseDto> getAll() {
        return movieSessionService.getAll()
                .stream()
                .map(movieSessionDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MovieSessionResponseDto get(@PathVariable Long id) {
        return movieSessionDtoMapper.toDto(movieSessionService.get(id));
    }

    @PostMapping
    public MovieSessionResponseDto create(
            @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        return movieSessionDtoMapper
                .toDto(movieSessionService
                        .add(movieSessionDtoMapper.toModel(movieSessionRequestDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieService.delete(movieService.get(id));
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(
            @PathVariable Long id,
            @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = movieSessionDtoMapper.toModel(movieSessionRequestDto);
        movieSession.setId(id);
        MovieSession updatedMovie = movieSessionService.update(movieSession);
        return movieSessionDtoMapper.toDto(updatedMovie);
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> available(@RequestParam Long movieId,
                                                   @RequestParam
                                                   @DateTimeFormat(pattern = "dd.MM.yyyy")
                                                   LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(movieSessionDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
