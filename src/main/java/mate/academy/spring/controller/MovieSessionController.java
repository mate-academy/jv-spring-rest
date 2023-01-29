package mate.academy.spring.controller;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
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

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionMapper movieSessionMapper;

    public MovieSessionController(@Autowired MovieSessionService movieSessionService,
                                  @Autowired MovieSessionMapper movieSessionMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @PostMapping
    public MovieSessionResponseDto add(@RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession =
                movieSessionService.add(movieSessionMapper.toModel(movieSessionRequestDto));
        return movieSessionMapper.toDto(movieSession);
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAvailable(
            @RequestParam Long id,
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy")LocalDate localDate) {
        return movieSessionService.findAvailableSessions(id, localDate).stream()
                .map(movieSessionMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        movieSessionService.update(id, movieSessionMapper.toModel(movieSessionRequestDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }
}
