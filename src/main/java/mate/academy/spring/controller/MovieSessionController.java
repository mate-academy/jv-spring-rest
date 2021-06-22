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
    private final CinemaHallService cinemaHallService;
    private final MovieService movieService;
    
    public MovieSessionController(MovieSessionService movieSessionService,
            MovieSessionDtoMapper movieSessionDtoMapper, CinemaHallService cinemaHallService,
            MovieService movieService) {
        this.movieSessionService = movieSessionService;
        this.movieSessionDtoMapper = movieSessionDtoMapper;
        this.cinemaHallService = cinemaHallService;
        this.movieService = movieService;
    }
    
    @PostMapping
    public MovieSessionResponseDto create(
            @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        return movieSessionDtoMapper.parseToDto(movieSessionService
                .add(movieSessionDtoMapper.toModel(movieSessionRequestDto)));
    }
    
    @GetMapping("/available")
    public List<MovieSessionResponseDto> findAvailableSessions(@RequestParam Long movieId,
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(movieSessionDtoMapper::parseToDto)
                .collect(Collectors.toList());
    }
    
    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
            @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = movieSessionDtoMapper.toModel(movieSessionRequestDto);
        movieSession.setId(id);
        MovieSession updateMovieSession = movieSessionService.update(movieSession);
        return movieSessionDtoMapper.parseToDto(updateMovieSession);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(movieSessionService.get(id));
    }
    
    @GetMapping("/inject")
    public String injectMockData() {
        CinemaHall redHall = new CinemaHall();
        redHall.setCapacity(100);
        redHall.setDescription("RED hall");
    
        CinemaHall blackHall = new CinemaHall();
        blackHall.setCapacity(150);
        blackHall.setDescription("BLACK hall");
    
        cinemaHallService.add(redHall);
        cinemaHallService.add(blackHall);
    
        Movie fastAndFurious = new Movie("Fast and Furious");
        fastAndFurious.setDescription("An action film about street racing, heists, and spies.");
    
        Movie matrix = new Movie("Matrix");
        matrix.setDescription(
                "The Matrix is a computer-generated dream world designed to keep these humans "
                        + "under control.");
    
        movieService.add(fastAndFurious);
        movieService.add(matrix);
        
        MovieSession fastAndFuriousRedHall = new MovieSession();
        fastAndFuriousRedHall.setCinemaHall(redHall);
        fastAndFuriousRedHall.setMovie(fastAndFurious);
        fastAndFuriousRedHall.setShowTime(LocalDateTime.now());
        
        MovieSession matrixBlackHall = new MovieSession();
        matrixBlackHall.setMovie(matrix);
        matrixBlackHall.setCinemaHall(blackHall);
        matrixBlackHall.setShowTime(LocalDateTime.now().plusDays(3L));
        movieSessionService.add(fastAndFuriousRedHall);
        movieSessionService.add(matrixBlackHall);
        return "Insert to DB!";
    }
}
