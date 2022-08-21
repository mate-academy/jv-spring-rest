package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionDtoMapper movieSessionDtoMapper;

    @Autowired
    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionDtoMapper movieSessionDtoMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionDtoMapper = movieSessionDtoMapper;
    }

    @PostMapping("/movie-sessions")
    @ResponseBody
    private MovieSessionResponseDto create(@RequestParam
                                           @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date,
                                           MovieSessionRequestDto movieSessionRequestDto) {
        movieSessionRequestDto.setShowTime(date);
        return movieSessionDtoMapper.parse(movieSessionService
                .add(movieSessionDtoMapper.toModel(movieSessionRequestDto)));
    }

    @GetMapping("/movie-sessions/available")
    @ResponseBody
    private List<MovieSessionResponseDto> getAvailableSessions(@RequestParam Long movieId,
                                                                @RequestParam LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(movieSessionDtoMapper::parse)
                .collect(Collectors.toList());
    }
}
