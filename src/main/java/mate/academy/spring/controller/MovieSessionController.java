package mate.academy.spring.controller;

import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MovieSessionController {
    private MovieSessionService movieSessionService;
    private MovieSessionMapper movieSessionMapper;

    @GetMapping ("/movie-sessions")
    public MovieSessionRequestDto add() {
    }

    @GetMapping("/movie-sessions/available?movieId=1&date=29.02.2020")
    public List<MovieSessionResponseDto> findAll(@RequestParam Long movieId, LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(ms -> movieSessionMapper.parseToResp(ms))
                .collect(Collectors.toList());
    }

    @GetMapping ("/movie-sessions/{id}")
    public void update() {
    }

    @GetMapping ("/movie-sessions/{id}")
    public void remove() {

    }
}
