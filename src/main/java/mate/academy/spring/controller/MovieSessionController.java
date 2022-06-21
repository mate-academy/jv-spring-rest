package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionDtoMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionDtoMapper movieSessionDtoMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionDtoMapper movieSessionDtoMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionDtoMapper = movieSessionDtoMapper;
    }

    @PostMapping("/movie-sessions")
    public MovieSessionResponseDto create(
            @RequestBody MovieSessionRequestDto requestDto) {
        return movieSessionDtoMapper
                .toDto(movieSessionService
                        .add(movieSessionDtoMapper.toModel(requestDto)));
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable Long movieId,
                                          @RequestBody MovieSessionRequestDto requestDto) {
        MovieSession session = movieSessionDtoMapper.toModel(requestDto);
        session.setId(movieId);
        MovieSession updatedSession = movieSessionService.update(session);
        return movieSessionDtoMapper.toDto(updatedSession);
    }

    @GetMapping("/")
    public List<MovieSessionResponseDto> getAll(@RequestParam Long movieId,
                                                @RequestParam @DateTimeFormat(
                                                        pattern = "dd.MM.yyyy")
                                                        LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date)
                .stream()
                .map(movieSessionDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(movieSessionService.get(id));
    }
}
