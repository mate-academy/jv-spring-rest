package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.request.MovieSessionRequestDto;
import mate.academy.spring.dto.response.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionDtoMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionDtoMapper sessionDtoMapper;
    private final MovieSessionService sessionService;

    public MovieSessionController(MovieSessionDtoMapper sessionDtoMapper,
                                  MovieSessionService sessionService) {
        this.sessionDtoMapper = sessionDtoMapper;
        this.sessionService = sessionService;
    }

    @PostMapping
    public MovieSessionResponseDto add(@RequestBody MovieSessionRequestDto sessionDto) {
        MovieSession movieSession = sessionDtoMapper.parseToModel(sessionDto);
        return sessionDtoMapper.parseToDto(sessionService.add(movieSession));
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> findAvailableSessions(@RequestParam Long movieId,
                                                               @RequestParam @DateTimeFormat
                                                                       (pattern = "dd.MM.yyyy")
                                                                       LocalDate date) {
        return sessionService.findAvailableSessions(movieId, date).stream()
                .map(sessionDtoMapper::parseToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestParam MovieSessionRequestDto sessionRequestDto) {
        MovieSession movieSession = sessionDtoMapper.parseToModel(sessionRequestDto);
        movieSession.setId(id);
        return sessionDtoMapper.parseToDto(sessionService.update(movieSession));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        MovieSession movieSession = sessionService.get(id);
        sessionService.delete(movieSession);
    }

}
