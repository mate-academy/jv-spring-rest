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
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "https://web.postman.co/")
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService sessionService;
    private final MovieSessionMapper sessionMapper;

    public MovieSessionController(MovieSessionService sessionService,
                                  MovieSessionMapper sessionMapper) {
        this.sessionService = sessionService;
        this.sessionMapper = sessionMapper;
    }

    @PostMapping
    public MovieSessionResponseDto create(
            @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession session = sessionService.add(
                sessionMapper.toModel(movieSessionRequestDto));
        return sessionMapper.toDto(session);
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> get(
            @RequestParam Long movieId,
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate localDate) {
        return sessionService.findAvailableSessions(movieId, localDate)
                .stream().map(sessionMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(
            @PathVariable Long id, @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession session = sessionMapper.toModel(movieSessionRequestDto);
        session.setId(id);
        sessionService.update(session);
        return sessionMapper.toDto(session);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        MovieSession session = sessionService.get(id);
        session.setId(id);
        sessionService.delete(session);
        return "Session deleted successfully";
    }
}
