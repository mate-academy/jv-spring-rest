package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
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
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService service;
    private final MovieSessionDtoMapper mapper;

    public MovieSessionController(MovieSessionService service, MovieSessionDtoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public MovieSessionResponseDto create(@RequestBody MovieSessionRequestDto reqDto) {
        return mapper.toDto(service.add(mapper.toModel(reqDto)));
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAllAvailable(
            @RequestParam Long movieId,
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return service.findAvailableSessions(movieId, date)
                .stream().map(mapper::toDto).toList();
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@RequestBody MovieSessionRequestDto reqDto,
                                                      @PathVariable long id) {
        MovieSession movieSession = mapper.toModel(reqDto);
        movieSession.setId(id);
        return mapper.toDto(service.update(movieSession));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
