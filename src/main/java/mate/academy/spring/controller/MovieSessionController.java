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
@RequestMapping("/")
public class MovieSessionController {
    private final MovieSessionDtoMapper movieSessionDtoMapper;
    private final MovieSessionService movieSessionService;

    @Autowired
    public MovieSessionController(MovieSessionDtoMapper movieSessionDtoMapper,
                                  MovieSessionService movieSessionService) {
        this.movieSessionDtoMapper = movieSessionDtoMapper;
        this.movieSessionService = movieSessionService;
    }

    @PostMapping("/movie-sessions")
    public MovieSessionResponseDto add(@RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        return movieSessionDtoMapper
                .toDto(movieSessionService.add(movieSessionDtoMapper
                        .toModel(movieSessionRequestDto)));
    }

    @GetMapping("/movie-sessions/available")
    public List<MovieSessionResponseDto> find(@PathVariable Long id,
                                              @RequestParam LocalDate localDate) {
        return movieSessionService.findAvailableSessions(id, localDate).stream()
                .map(movieSessionDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping(" /movie-sessions/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody MovieSessionRequestDto
                                                  movieSessionRequestDto) {
        MovieSession movieSession = movieSessionDtoMapper.toModel(movieSessionRequestDto);
        movieSession.setId(id);

        MovieSession updatedMovie = movieSessionService.update(movieSession);

        return movieSessionDtoMapper.toDto(updatedMovie);
    }

    @DeleteMapping("/movie-sessions/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }
}
