package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionMapper;
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
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    @Autowired
    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapper movieSessionMapper,
                                  MovieService movieService,
                                  CinemaHallService cinemaHallService) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    @PostMapping
    public MovieSessionResponseDto add(@RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        Movie movie = movieService.get(movieSessionRequestDto.getMovieId());
        CinemaHall cinemaHall = cinemaHallService.get(movieSessionRequestDto.getCinemaHallId());
        MovieSession movieSession =
                movieSessionMapper.toModel(movieSessionRequestDto, movie, cinemaHall);
        MovieSession addedMovieSession = movieSessionService.add(movieSession);
        return movieSessionMapper.toDto(addedMovieSession);
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAllAvailable(
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date,
            @RequestParam Long movieId) {
        return movieSessionService
                .findAvailableSessions(movieId, date)
                .stream()
                .map(movieSessionMapper::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{movieSessionId}")
    public void delete(@PathVariable Long movieSessionId) {
        movieSessionService.delete(movieSessionId);
    }

    @PutMapping("/{movieSessionId}")
    public void update(@PathVariable Long movieSessionId,
                       @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        Movie movie = movieService.get(movieSessionRequestDto.getMovieId());
        CinemaHall cinemaHall = cinemaHallService.get(movieSessionRequestDto.getCinemaHallId());
        MovieSession movieSession = movieSessionMapper.toModel(
                movieSessionRequestDto, movie, cinemaHall, movieSessionId);
        movieSessionService.update(movieSession);
    }
}
