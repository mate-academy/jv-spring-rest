package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
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
    private final MovieSessionService movieSessionService;
    private final MovieSessionDtoMapper dtoMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionDtoMapper dtoMapper) {
        this.movieSessionService = movieSessionService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAvailableMovieSessions(
                    @RequestParam("movieId") Long movieId,
                    @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate localDate) {
        return movieSessionService.findAvailableSessions(movieId, localDate).stream()
                    .map(dtoMapper::parse)
                    .collect(Collectors.toList());
    }

    @PostMapping("")
    public MovieSessionResponseDto add(@RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        return dtoMapper.parse(movieSessionService.add(dtoMapper
                    .toModel(movieSessionRequestDto)));
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(
                        @PathVariable Long id,
                        @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession session = dtoMapper.toModel(movieSessionRequestDto);
        session.setId(id);
        return dtoMapper.parse(movieSessionService.update(session));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }
}
