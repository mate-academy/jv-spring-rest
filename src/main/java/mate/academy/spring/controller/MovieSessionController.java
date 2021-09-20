package mate.academy.spring.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import mate.academy.spring.service.mapper.MovieSessionDtoMapper;
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
    private final MovieSessionDtoMapper movieSessionDtoMapper;
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionDtoMapper movieSessionDtoMapper,
                                  MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieSessionService = movieSessionService;
        this.movieSessionDtoMapper = movieSessionDtoMapper;
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAvailable(@RequestParam Long movieId,
                    @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(movieSessionDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public MovieSessionResponseDto create(@RequestBody MovieSessionRequestDto requestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(requestDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(requestDto.getCinemaHallId()));
        movieSession.setShowTime(requestDto.getShowTime());
        return movieSessionDtoMapper.toDto(movieSessionService.add(movieSession));
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                     @RequestBody MovieSessionRequestDto requestDto) {
        MovieSession movieSession = movieSessionDtoMapper.toModel(requestDto);
        movieSession.setId(id);
        return movieSessionDtoMapper.toDto(movieSessionService.update(movieSession));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        movieSessionService.delete(id);
    }

    @GetMapping("/inject")
    public String injectMockData() {
        Movie fastAndFurious = new Movie("Fast and Furious");
        fastAndFurious.setDescription("An action film about street racing, heists, and spies.");
        movieService.add(fastAndFurious);

        Movie movieTerminator = new Movie("The Terminator");
        movieTerminator.setDescription("Action with Arnold Schwarzenegger. 1984");
        movieService.add(movieTerminator);

        CinemaHall yellow = new CinemaHall();
        yellow.setCapacity(20);
        yellow.setDescription("Yellow hall");
        cinemaHallService.add(yellow);

        CinemaHall green = new CinemaHall();
        green.setCapacity(80);
        green.setDescription("Green hall");
        cinemaHallService.add(green);

        MovieSession msFastAndFurious1 = new MovieSession(fastAndFurious, yellow,
                LocalDateTime.of(2021, 9, 12, 9, 0));
        movieSessionService.add(msFastAndFurious1);

        MovieSession msFastAndFurious2 = new MovieSession(fastAndFurious, yellow,
                LocalDateTime.of(2021, 9, 12, 12, 0));
        movieSessionService.add(msFastAndFurious2);

        MovieSession msFastAndFurious3 = new MovieSession(fastAndFurious, green,
                LocalDateTime.of(2021, 9, 12, 18, 0));
        movieSessionService.add(msFastAndFurious3);

        MovieSession msFastAndFurious4 = new MovieSession(fastAndFurious, yellow,
                LocalDateTime.of(2021, 9, 14, 9, 0));
        movieSessionService.add(msFastAndFurious4);

        MovieSession msFastAndFurious5 = new MovieSession(fastAndFurious, green,
                LocalDateTime.of(2021, 9, 14, 9, 0));
        movieSessionService.add(msFastAndFurious5);

        MovieSession msTerminator1 = new MovieSession(movieTerminator, green,
                LocalDateTime.of(2021, 9, 12, 9, 0));
        movieSessionService.add(msTerminator1);

        MovieSession msTerminator2 = new MovieSession(movieTerminator, yellow,
                LocalDateTime.of(2021, 9, 12, 18, 0));
        movieSessionService.add(msTerminator2);

        return "The testing data was injected!";
    }
}
