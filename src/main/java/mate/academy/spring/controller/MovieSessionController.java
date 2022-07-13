package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionMapper;
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
@RequestMapping("movie-sessions")
public class MovieSessionController {
    private static MovieSessionService movieSessionService;
    private static MovieSessionMapper movieSessionMapper;

    public MovieSessionController(MovieSessionService service, MovieSessionMapper mapper) {
        this.movieSessionService = service;
        this.movieSessionMapper = mapper;
    }

    @PostMapping
    public MovieSessionResponseDto add(@RequestBody MovieSessionRequestDto requestDto) {
        return movieSessionMapper.toDto(movieSessionService.add(movieSessionMapper.toModel(requestDto)));
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAllAvailable(
            @RequestParam Long movieId,
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date
    ) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(movieSessionMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody MovieSessionRequestDto requestDto) {
        return movieSessionMapper.toDto(movieSessionService.update(movieSessionMapper.toModel(requestDto, id)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id,
                       @RequestBody MovieSessionRequestDto requestDto) {
        movieSessionService.remove(movieSessionMapper.toModel(requestDto, id));
    }
}
