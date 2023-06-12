package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionMapper mapper;

    @Autowired
    public MovieSessionController(MovieSessionService service, MovieSessionMapper mapper) {
        this.movieSessionService = service;
        this.mapper = mapper;
    }

    @PostMapping("/movie-sessions")
    public MovieSessionResponseDto add(@RequestBody MovieSessionRequestDto movieSession) {
        return mapper.toDto(movieSessionService.add(mapper.toModel(movieSession)));
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAllAvailable(@RequestParam Long movieId,
                                                         @RequestParam
                                                         @DateTimeFormat(pattern = "dd.MM.yyyy")
                                                         LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/movie-sessions/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody MovieSessionRequestDto requestDto) {
        MovieSession movieSession = mapper.toModel(requestDto);
        movieSession.setId(id);
        movieSessionService.update(movieSession);
        return mapper.toDto(movieSession);
    }

    @DeleteMapping("/movie-session/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(movieSessionService.get(id));
    }
}
