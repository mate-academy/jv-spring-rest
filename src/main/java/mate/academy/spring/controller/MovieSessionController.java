package mate.academy.spring.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.util.MovieSessionMapper;
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
    private final MovieSessionMapper movieSessionMapper;
    private final MovieSessionService movieSessionService;
    private final CinemaHallService cinemaHallService;
    private final MovieService movieService;

    public MovieSessionController(MovieSessionMapper movieSessionMapper,
                                  MovieSessionService movieSessionService,
                                  CinemaHallService cinemaHallService,
                                  MovieService movieService) {
        this.movieSessionMapper = movieSessionMapper;
        this.movieSessionService = movieSessionService;
        this.cinemaHallService = cinemaHallService;
        this.movieService = movieService;
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAvailable(@RequestParam Long movieId,
                                                      @RequestParam
                                                      @DateTimeFormat(pattern = "dd.MM.yyyy")
                                                      LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date)
                .stream()
                .map(movieSessionMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("")
    public MovieSessionResponseDto add(@RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        movieSessionRequestDto.setShowTime(LocalDateTime.now());
        MovieSession movieSession =
                movieSessionService.add(movieSessionMapper.toModel(movieSessionRequestDto));
        return movieSessionMapper.toDto(movieSession);
    }

    @DeleteMapping("/{id}")
    public MovieSessionResponseDto delete(@PathVariable Long id) {
        MovieSessionResponseDto movieSessionResponseDto = movieSessionMapper.toDto(movieSessionService.get(id));
        movieSessionService.delete(movieSessionService.get(id));
        return movieSessionResponseDto;
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody
                                          MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = movieSessionMapper.toModel(movieSessionRequestDto);
        movieSession.setId(id);
        MovieSession updatedMovieSession = movieSessionService.update(movieSession);
        return movieSessionMapper.toDto(updatedMovieSession);
    }
}
