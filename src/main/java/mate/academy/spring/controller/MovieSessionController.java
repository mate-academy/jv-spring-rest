package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponceDto;
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
@RequestMapping("movie-sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionMapper movieSessionMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapper movieSessionMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @GetMapping("/available")
    public List<MovieSessionResponceDto> getAllAvailable(@RequestParam Long id,
                                                         @RequestParam
                                                         @DateTimeFormat(pattern = "dd.MM.yyyy")
                                                                 LocalDate date) {
        return movieSessionService.findAvailableSessions(id, date).stream()
                .map(movieSessionMapper::parseToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public MovieSessionResponceDto add(@RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        return movieSessionMapper.parseToDto(movieSessionService
                .add(movieSessionMapper.parseToModel(movieSessionRequestDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }

    @PutMapping("/{id}")
    public MovieSessionResponceDto update(@PathVariable Long id,
                                          @RequestBody MovieSessionRequestDto requestDto) {
        MovieSession movieSession = movieSessionMapper.parseToModel(requestDto);
        movieSession.setId(id);
        MovieSession updated = movieSessionService.update(movieSession);
        return movieSessionMapper.parseToDto(updated);
    }
}
