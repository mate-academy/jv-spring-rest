package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.MovieSessionMapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionRespondDto;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/movie-sessions")
@ResponseBody
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionMapper movieSessionMapper;

    public MovieSessionController(MovieSessionService service, MovieSessionMapper mapper) {
        this.movieSessionService = service;
        this.movieSessionMapper = mapper;
    }

    @GetMapping("/available")
    public List<MovieSessionRespondDto> getAllAvailable(@RequestParam Long movieId,
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(movieSessionMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieSessionRespondDto create(@RequestBody MovieSessionRequestDto requestDto) {
        MovieSession movieSession = movieSessionService.add(movieSessionMapper.toModel(requestDto));
        return movieSessionMapper.toDto(movieSession);
    }

    @PutMapping("/{id}")
    public MovieSessionRespondDto update(@RequestBody MovieSessionRequestDto requestDto,
             @PathVariable Long id) {
        MovieSession movieSession = movieSessionMapper.toModel(requestDto);
        movieSession.setId(id);
        return movieSessionMapper.toDto(movieSessionService.update(movieSession));
    }

    @DeleteMapping("/{id}")
    public MovieSessionRespondDto delete(@PathVariable Long id) {
        return movieSessionMapper.toDto(movieSessionService.delete(id));
    }
}

