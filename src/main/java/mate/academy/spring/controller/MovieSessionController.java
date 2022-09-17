package mate.academy.spring.controller;

import mate.academy.spring.dto.*;
import mate.academy.spring.mapper.MovieSessionDtoMapper;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionDtoMapper movieSessionDtoMapper;

    public MovieSessionController(
            MovieSessionService movieSessionService,
            MovieSessionDtoMapper movieSessionDtoMapper,
            MovieService movieService,
            CinemaHallService cinemaHallService) {
        this.movieSessionService = movieSessionService;
        this.movieSessionDtoMapper = movieSessionDtoMapper;
    }

    @PostMapping
    public MovieSessionResponseDto create(@RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        return movieSessionDtoMapper.toDto(movieSessionService.add(movieSessionDtoMapper.toModel(movieSessionRequestDto)));
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> findAllAvailable(
            @RequestParam Long movieId,
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(movieSessionDtoMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/available-full")
    public List<MovieSessionResponseDtoFull> findAllAvailableSessionsFull(
            @RequestParam Long movieId,
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        List<Object> all = new ArrayList<>();
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(movieSessionDtoMapper::toDtoFull).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update (
            @PathVariable Long id,
            @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = movieSessionDtoMapper.toModel(movieSessionRequestDto);
        movieSession.setId(id);
        return movieSessionDtoMapper.toDto(movieSessionService.update(movieSession));
    }
}
