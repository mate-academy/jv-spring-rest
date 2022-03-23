package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    private MovieSessionService service;
    private MovieSessionMapper mapper;

    @Autowired
    public MovieSessionController(MovieSessionService service,
                                  MovieSessionMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public MovieSessionResponseDto create(@RequestBody MovieSessionRequestDto requestDto) {
        MovieSession createdMovieSession = service.add(mapper.toModel(requestDto));
        return mapper.toResponseDto(createdMovieSession);
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> findAvailable(@RequestParam Long movieId,
                                                       @RequestParam
                                                       @DateTimeFormat(pattern = "dd.MM.yyyy")
                                                               LocalDate date) {
        return service.findAvailableSessions(movieId, date)
                .stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable("id") Long movieSessionId,
                                          @RequestBody MovieSessionRequestDto requestDto) {
        MovieSession model = mapper.toModel(requestDto);
        model.setId(movieSessionId);
        service.update(model);
        return mapper.toResponseDto(model);
    }

    @DeleteMapping("/{id}")
    public MovieSessionRequestDto delete(@PathVariable("id") Long movieSessionId) {
        MovieSession model = service.get(movieSessionId);
        return mapper.toRequestDto(service.delete(model));

    }
}
