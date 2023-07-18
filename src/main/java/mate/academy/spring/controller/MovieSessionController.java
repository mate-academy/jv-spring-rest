package mate.academy.spring.controller;

import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionDtoMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("movie-sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionDtoMapper movieSessionDtoMapper;

    public MovieSessionController(MovieSessionService movieSessionService, MovieSessionDtoMapper movieSessionDtoMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionDtoMapper = movieSessionDtoMapper;
    }

    @PostMapping
    public MovieSessionResponseDto add(@RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSessionFromDto = movieSessionDtoMapper.toModel(movieSessionRequestDto);
        MovieSession movieSessionFromDb = movieSessionService.add(movieSessionFromDto);
        return MovieSessionDtoMapper.parse(movieSessionFromDb);
    }

    @GetMapping("/available?{movieId}&{localDate}")
    public List<MovieSessionResponseDto>
    getByParameters(@PathVariable @RequestBody Long movieId,
                    @PathVariable @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate localDate) {
        return movieSessionService.findAvailableSessions(movieId, localDate).stream()
                .map(MovieSessionDtoMapper::parse)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = movieSessionDtoMapper.toModel(movieSessionRequestDto);
        movieSession.setId(id);
        MovieSession updatedMovieSession = movieSessionService.update(movieSession);
        return MovieSessionDtoMapper.parse(updatedMovieSession);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }
}
