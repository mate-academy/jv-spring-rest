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
    private final MovieSessionMapper sessionMapper;
    private final MovieSessionService sessionService;

    public MovieSessionController(MovieSessionMapper sessionMapper,
                                  MovieSessionService sessionService) {
        this.sessionMapper = sessionMapper;
        this.sessionService = sessionService;
    }

    @PostMapping
    public MovieSessionResponseDto create(@RequestBody MovieSessionRequestDto requestDto) {
        return sessionMapper.toDto(sessionService.add(sessionMapper.toModel(requestDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sessionService.delete(id);
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@RequestBody MovieSessionRequestDto requestDto,
                                          @PathVariable Long id) {
        MovieSession model = sessionMapper.toModel(requestDto);
        model.setId(id);
        MovieSession updated = sessionService.update(model);
        return sessionMapper.toDto(updated);
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> findAvailableSession(
            @RequestParam Long movieId, @RequestParam @DateTimeFormat(
                    pattern = "dd.MM.yyyy")LocalDate localDate) {
        return sessionService.findAvailableSessions(movieId, localDate)
                .stream()
                .map(sessionMapper::toDto)
                .collect(Collectors.toList());
    }
}
