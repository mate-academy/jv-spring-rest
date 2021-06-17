package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionMapper;
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
    private final MovieSessionService service;
    private final MovieSessionMapper mapper;

    public MovieSessionController(MovieSessionService service, MovieSessionMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<MovieSessionResponseDto> getAll() {
        return service.getAll().stream()
                        .map(mapper::parse)
                        .collect(Collectors.toList());
    }

    @PostMapping
    public MovieSessionResponseDto createMovieSession(
            @RequestBody MovieSessionRequestDto requestDto) {
        return mapper.parse(service.add(mapper.toModel(requestDto)));
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAvailableSession(
            @RequestParam Long id,
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return service.findAvailableSessions(id, date).stream()
                .map(mapper::parse)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto updateSession(@PathVariable Long id,
                                                 @RequestBody MovieSessionRequestDto requestDto) {
        MovieSession movieSession = mapper.toModel(requestDto);
        movieSession.setId(id);
        return mapper.parse(service.update(movieSession.getId()));
    }

    @DeleteMapping("/{id}")
    public void deleteSession(@PathVariable Long id) {
        service.delete(id);
    }
}
