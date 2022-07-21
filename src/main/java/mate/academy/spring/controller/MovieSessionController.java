package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.mapper.MovieSessionMapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
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

@RestController // = @Controller + @ResponseBody
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService sessionService;
    private final MovieSessionMapper sessionMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapper movieSessionMapper) {
        this.sessionService = movieSessionService;
        this.sessionMapper = movieSessionMapper;
    }

    @PostMapping
    public MovieSessionResponseDto create(@RequestBody MovieSessionRequestDto requestDto) {
        MovieSession movieSession = sessionService.add(sessionMapper.parseToModel(requestDto));
        return sessionMapper.parseFromModel(movieSession);
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAllByMovieAndDate(
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy")
            Long movieId, LocalDate date) {
        return sessionService.findAvailableSessions(movieId, date).stream()
                .map(sessionMapper::parseFromModel)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody MovieSessionRequestDto requestDto) {
        MovieSession movieSession = sessionMapper.parseToModel(requestDto);
        movieSession.setId(id);
        return sessionMapper.parseFromModel(sessionService.update(movieSession));
    }

    @DeleteMapping("/{id}")
    public MovieSessionResponseDto delete(@PathVariable Long id) {
        MovieSession movieSession = sessionService.get(id);
        sessionService.delete(movieSession);
        return sessionMapper.parseFromModel(movieSession);
    }
}
