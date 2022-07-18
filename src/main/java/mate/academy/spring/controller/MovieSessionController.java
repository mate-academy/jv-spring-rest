package mate.academy.spring.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.MovieSessionMapper;
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
@RequestMapping("/movie_sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionMapper mapper;
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapper mapper, MovieService movieService,
                                  CinemaHallService cinemaHallService) {
        this.movieSessionService = movieSessionService;
        this.mapper = mapper;
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAll(@RequestParam Long movieId,
                                                @RequestParam
                                                @DateTimeFormat(pattern = "dd.MM.yyyy")
                                                LocalDate date) {
        LocalDateTime dateStart = date.atTime(0, 0, 0);
        LocalDateTime dateEnd = date.atTime(23, 59, 59);
        return movieSessionService.getAll().stream()
                .filter(x -> x.getMovie().getId() == movieId
                        && x.getShowTime().isAfter(dateStart)
                        && x.getShowTime().isBefore(dateEnd))
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public MovieSessionResponseDto create(@RequestBody MovieSessionRequestDto dto) {
        MovieSession movieSession = mapper.toModel(dto);
        MovieSession sessionFromDb = movieSessionService.add(movieSession);
        return mapper.toDto(sessionFromDb);
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@RequestBody MovieSessionRequestDto dto,
                                          @PathVariable Long id) {
        MovieSession movieSession = mapper.toModel(dto);
        movieSession.setId(id);
        MovieSession sessionFromDb = movieSessionService.update(movieSession);
        return mapper.toDto(sessionFromDb);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }
}
