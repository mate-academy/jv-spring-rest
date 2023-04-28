package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
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
    private final MovieSessionMapper movieSessionMapper;
    private final MovieSessionService movieSessionService;

    public MovieSessionController(MovieSessionMapper movieSessionMapper,
                                  MovieSessionService movieSessionService) {
        this.movieSessionMapper = movieSessionMapper;
        this.movieSessionService = movieSessionService;
    }

    @PostMapping
    public MovieSessionResponseDto create(@RequestBody MovieSessionRequestDto requestDto) {
        return movieSessionMapper.toDto(movieSessionService.add(movieSessionMapper.toModel(requestDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@RequestBody MovieSessionRequestDto requestDto,
                                          @PathVariable Long id) {
        MovieSession model = movieSessionMapper.toModel(requestDto);
        model.setId(id);
        MovieSession updated = movieSessionService.update(model);
        return movieSessionMapper.toDto(updated);
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> findAvailableSession(
            @RequestParam Long movieId, @RequestParam @DateTimeFormat(
                    pattern = "dd.MM.yyyy") LocalDate localDate) {
        return movieSessionService.findAvailableSessions(movieId, localDate)
                .stream()
                .map(movieSessionMapper::toDto)
                .collect(Collectors.toList());
    }
}
