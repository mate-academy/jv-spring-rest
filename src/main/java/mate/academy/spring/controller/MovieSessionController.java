package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.request.MovieSessionRequestDto;
import mate.academy.spring.model.dto.response.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionDtoMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieSessionController {
    private MovieSessionService movieSessionService;
    private MovieSessionDtoMapper dtoMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionDtoMapper dtoMapper) {
        this.movieSessionService = movieSessionService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/movie-sessions/available")
    public List<MovieSessionResponseDto> getAvailableSessions(@RequestParam Long id,
                @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return movieSessionService.findAvailableSessions(id, date).stream()
                .map(dtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/movie-sessions")
    public MovieSessionResponseDto addMovieSession(@RequestBody MovieSessionRequestDto request) {
        return dtoMapper.toDto(movieSessionService.add(dtoMapper.toModel(request)));
    }

    @DeleteMapping("/movie-sessions/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }

    @PutMapping("/movie-sessions/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody MovieSessionRequestDto movieSession) {
        MovieSession mapperModel = dtoMapper.toModel(movieSession);
        mapperModel.setId(id);
        MovieSession updatedMovieSession = movieSessionService.update(mapperModel);
        return dtoMapper.toDto(updatedMovieSession);
    }
}
