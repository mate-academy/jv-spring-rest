package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionDtoMapper;
import mate.academy.spring.util.DateUtil;
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
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;
    private final MovieSessionDtoMapper movieSessionDtoMapper;

    @Autowired
    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieService movieService,
                                  CinemaHallService cinemaHallService,
                                  MovieSessionDtoMapper movieSessionDtoMapper) {
        this.movieSessionService = movieSessionService;
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
        this.movieSessionDtoMapper = movieSessionDtoMapper;
    }

    @PostMapping
    public void add(@RequestBody MovieSessionRequestDto requestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(requestDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(requestDto.getCinemaHallId()));
        movieSession.setShowTime(DateUtil.toLocalDateTime(requestDto.getShowTime()));
        movieSessionService.add(movieSession);
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getByIdAndDate(@RequestParam Long movieId,
                    @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(movieSessionDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody MovieSessionRequestDto requestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setId(id);
        movieSession.setMovie(movieService.get(requestDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(requestDto.getCinemaHallId()));
        movieSession.setShowTime(DateUtil.toLocalDateTime(requestDto.getShowTime()));
        movieSessionService.update(movieSession);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        movieSessionService.remove(id);
    }

    @GetMapping
    public List<MovieSessionResponseDto> getAll() {
        return movieSessionService.getAll().stream()
                .map(movieSessionDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
