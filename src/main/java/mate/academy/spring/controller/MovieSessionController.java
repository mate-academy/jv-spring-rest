package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
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
@AllArgsConstructor
public class MovieSessionController {
    private MovieSessionService sessionService;
    private MovieSessionDtoMapper sessionMapper;

    @PostMapping
    public MovieSessionResponseDto add(@RequestBody MovieSessionRequestDto sessionRequestDto) {
        MovieSession session = sessionMapper.toModel(sessionRequestDto);
        return sessionMapper.parse(sessionService.add(session));
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAvailable(
            @RequestParam Long movieId, @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return sessionService.findAvailableSessions(movieId, date).stream()
                .map(sessionMapper::parse).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(
            @PathVariable Long id, @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession session = sessionMapper.toModel(movieSessionRequestDto);
        session.setId(id);
        return sessionMapper.parse(sessionService.update(session));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sessionService.delete(id);
    }
}


/*
Get all available movie sessions - GET: /movie-sessions/available?movieId=1&date=29.02.2020
 */
