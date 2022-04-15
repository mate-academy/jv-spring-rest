package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapper movieSessionMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @PostMapping
    public MovieSessionResponseDto add(@RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = movieSessionMapper.toModel(movieSessionRequestDto);
        MovieSession movieSessionFromDb = movieSessionService.add(movieSession);
        return movieSessionMapper.toResponseDto(movieSessionFromDb);
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAvailableMovieSessions(@RequestParam Long movieId,
                                                                   @RequestParam LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(movieSessionMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{movieSessionId}")
    public MovieSessionResponseDto update(@PathVariable Long movieSessionId,
                                          @RequestBody
                                                  MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession newMovieSession = movieSessionMapper.toModel(movieSessionRequestDto);
        newMovieSession.setId(movieSessionId);
        return movieSessionMapper.toResponseDto(movieSessionService.update(newMovieSession));
    }

    @DeleteMapping("/{movieSessionId}")
    public String delete(@PathVariable Long movieSessionId) {
        movieSessionService.delete(movieSessionId);
        return "Successfully deleted!";
    }
}
