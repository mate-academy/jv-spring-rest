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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-session")
public class MovieSessionController {
    private MovieSessionService service;
    private MovieSessionDtoMapper mapper;

    public MovieSessionController(MovieSessionService service,
                                  MovieSessionDtoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public MovieSessionResponseDto post(@RequestBody MovieSessionRequestDto dto) {
        MovieSession session = service.add(mapper.toMovieSession(dto));
        return mapper.parse(session);
    }

    @GetMapping
    public List<MovieSessionResponseDto> get(@RequestParam Long id, @RequestParam
            @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return service.findAvailableSessions(id, date).stream()
                .map(mapper::parse)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@RequestBody MovieSessionRequestDto dto,
                                          @PathVariable Long id) {
        MovieSession session = mapper.toMovieSession(dto);
        session.setId(id);
        return mapper.parse(service.update(session));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
