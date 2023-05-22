package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.moviesession.MovieSessionRequestDto;
import mate.academy.spring.dto.moviesession.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionDtoMapper;
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

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionDtoMapper movieSessionDtoMapper;

    @Autowired
    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionDtoMapper movieSessionDtoMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionDtoMapper = movieSessionDtoMapper;
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAll(@RequestParam Long id,
                                                @RequestParam @DateTimeFormat
                                                        (pattern = "dd.MM.yyyy")
                                                LocalDate showTime) {
        List<MovieSession> availableSessions = movieSessionService
                .findAvailableSessions(id, showTime);
        return availableSessions.stream()
                .map(movieSessionDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping()
    public MovieSessionResponseDto create(
            @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSessionModel = movieSessionDtoMapper.toModel(movieSessionRequestDto);
        MovieSession movieSessionFromDb = movieSessionService.add(movieSessionModel);
        return movieSessionDtoMapper.toDto(movieSessionFromDb);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return movieSessionService.delete(id);
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody MovieSessionRequestDto
                                                  movieSessionRequestDto) {
        MovieSession model = movieSessionDtoMapper.toModel(movieSessionRequestDto);
        model.setId(id);
        MovieSession updatedMovieSession = movieSessionService.update(model);
        return movieSessionDtoMapper.toDto(updatedMovieSession);
    }
}
