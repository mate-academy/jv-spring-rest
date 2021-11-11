package mate.academy.spring.controller;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.moviesessiondto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.moviesessiondto.MovieSessionResponseDto;
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
    private MovieSessionService service;
    private MovieSessionDtoMapper mapper;

    public MovieSessionController(MovieSessionService service, MovieSessionDtoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/avialable")
    public List<MovieSessionResponseDto>
            availableSession(@RequestParam Long id,
                     @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return service.findAvailableSessions(id, date).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public MovieSessionResponseDto create(@RequestBody
                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                      MovieSessionRequestDto requestDto) {
        return mapper.toDto(service.add(mapper.toMovieSession(requestDto)));
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id, @RequestBody
            MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = mapper.toMovieSession(movieSessionRequestDto);
        movieSession.setId(id);
        return mapper.toDto(service.upgrade(movieSession));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
