package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MoviesSessionDtoMapper;
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
@RequestMapping("/movies-sessions")
public class MoviesSessionController {

    private final MovieSessionService sessionService;
    private final MoviesSessionDtoMapper dtoMapper;

    public MoviesSessionController(MovieSessionService sessionService,
                                   MoviesSessionDtoMapper dtoMapper) {
        this.sessionService = sessionService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto>
            getAllAvailableMovieSessions(@RequestParam Long movieId,
                                 @RequestParam @DateTimeFormat(pattern = "dd.mm.yyyy")
                                 LocalDate date) {
        return sessionService.findAvailableSessions(movieId, date).stream()
                .map(dtoMapper::parse)
                .collect(Collectors.toList());
    }

    @PostMapping
    public MovieSessionResponseDto create(@RequestBody MovieSessionRequestDto requestDto) {
        return dtoMapper.parse(sessionService.add(dtoMapper.toModel(requestDto)));
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody MovieSessionRequestDto requestDto) {
        MovieSession session = dtoMapper.toModel(requestDto);
        session.setId(id);
        return dtoMapper.parse(sessionService.update(session));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sessionService.delete(sessionService.get(id));
    }
}
