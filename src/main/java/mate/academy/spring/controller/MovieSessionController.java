package mate.academy.spring.controller;

import mate.academy.spring.dto.movie_session.MovieSessionRequestDto;
import mate.academy.spring.dto.movie_session.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionDtoMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie_sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionDtoMapper movieSessionDtoMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionDtoMapper movieSessionDtoMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionDtoMapper = movieSessionDtoMapper;
    }

    @PostMapping
    public MovieSessionResponseDto createMovieSession(@RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        return movieSessionDtoMapper.toDto(movieSessionService
                .add(movieSessionDtoMapper
                        .toModel(movieSessionRequestDto)));
    }

    @DeleteMapping("/{id}")
    public void deleteMovieSession(@PathVariable Long id) {
        movieSessionService.delete(id);
    }

    @PutMapping("/{id")
    public MovieSessionResponseDto updateMovieSession(@PathVariable Long id,
                                                      @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = movieSessionDtoMapper.toModel(movieSessionRequestDto);
        movieSession.setId(id);
        return movieSessionDtoMapper.toDto(movieSessionService.update(movieSession));
    }
}
