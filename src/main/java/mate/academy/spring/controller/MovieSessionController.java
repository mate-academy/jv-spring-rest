package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionDtoMapper movieSessionMapper;

    @Autowired
    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionDtoMapper movieSessionMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieSessionResponseDto add(
            @RequestBody MovieSessionRequestDto requestDto) {
        return movieSessionMapper.toResponse(movieSessionService.add(
                movieSessionMapper.toModel(requestDto)));
    }

    @GetMapping()
    public List<MovieSessionResponseDto> getAll() {
        return movieSessionService.getAll().stream()
                .map(movieSessionMapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/find")
    public List<MovieSessionResponseDto> findAllByMovieId(@RequestParam Long movieId) {
        return movieSessionService.findAllByMovieId(movieId).stream()
                .map(movieSessionMapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAvailable(@RequestParam Long movieId,
                                                      @RequestParam
                                                      @DateTimeFormat(pattern = "dd.MM.yyyy")
                                                      LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(movieSessionMapper::toResponse)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@RequestBody MovieSessionRequestDto requestDto,
                                          @PathVariable Long id) {
        MovieSession movieSession = movieSessionMapper.toModel(requestDto);
        movieSession.setId(id);
        return movieSessionMapper.toResponse(movieSessionService.update(movieSession));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }
}
