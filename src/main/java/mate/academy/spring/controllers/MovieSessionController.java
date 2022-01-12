package mate.academy.spring.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.dto.MovieSessionDtoMapper;
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
    private final MovieSessionDtoMapper movieSessionMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                          MovieSessionDtoMapper movieSessionMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> findAvailableSessions(
            @RequestParam Long movieId, @RequestParam @DateTimeFormat(
                    pattern = "dd.MM.yyyy") LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date)
                .stream()
                .map(movieSessionMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public MovieSessionResponseDto add(@RequestBody MovieSessionRequestDto dto) {
        MovieSession movieSession = movieSessionService.add(movieSessionMapper.mapToModel(dto));
        return movieSessionMapper.mapToDto(movieSession);
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(
            @PathVariable Long id, @RequestBody MovieSessionRequestDto dto) {
        MovieSession movieSession = movieSessionMapper.mapToModel(dto);
        movieSession.setId(id);
        return movieSessionMapper.mapToDto(movieSessionService.update(movieSession));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.remove(movieSessionService.get(id));
    }
}
