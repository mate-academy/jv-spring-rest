package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.moviesession.MovieSessionRequestDto;
import mate.academy.spring.model.dto.moviesession.MovieSessionResponseDto;
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
    private final MovieSessionService service;
    private final MovieSessionMapper mapper;

    public MovieSessionController(MovieSessionService service,
            MovieSessionMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public MovieSessionResponseDto add(@RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        return mapper.parse(service.add(mapper.parse(movieSessionRequestDto)));
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
            @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = mapper.parse(movieSessionRequestDto);
        movieSession.setId(id);
        MovieSession updatedMovieSession = service.update(movieSession);
        return mapper.parse(updatedMovieSession);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        service.delete(id);
        return id;
    }

    @GetMapping("/")
    public List<MovieSessionResponseDto> getAvailable(@RequestParam Long movieId,
            @RequestParam
            @DateTimeFormat(pattern = "dd.MM.yyyy")
                    LocalDate date) {
        return service.findAvailableSessions(movieId, date)
                .stream()
                .map(mapper::parse)
                .collect(Collectors.toList());
    }
}
