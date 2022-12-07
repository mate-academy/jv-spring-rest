package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import mate.academy.spring.dto.request.MovieSessionRequestDto;
import mate.academy.spring.dto.response.MovieSessionResponseDto;
import mate.academy.spring.exception.MovieSessionNotFoundException;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
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
    private final MovieSessionService movieSessionService;
    private final DtoResponseMapper<MovieSession, MovieSessionResponseDto> responseDtoMapper;
    private final DtoRequestMapper<MovieSession, MovieSessionRequestDto> requestDtoMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  DtoResponseMapper<MovieSession,
                                          MovieSessionResponseDto> responseDtoMapper,
                                  DtoRequestMapper<MovieSession,
                                          MovieSessionRequestDto> requestDtoMapper) {
        this.movieSessionService = movieSessionService;
        this.responseDtoMapper = responseDtoMapper;
        this.requestDtoMapper = requestDtoMapper;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public MovieSessionResponseDto add(@RequestBody MovieSessionRequestDto dto) {
        MovieSession movieSession = movieSessionService.add(requestDtoMapper.toModel(dto));
        return responseDtoMapper.toDto(movieSession);
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAllAvailableSessions(
            @RequestParam
            Long movieId,
            @RequestParam
            @DateTimeFormat(pattern = "dd.MM.yyyy")
            LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date)
                .stream()
                .map(responseDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody
                       MovieSessionRequestDto dto) {
        MovieSession movieSession = requestDtoMapper.toModel(dto);
        movieSession.setId(id);
        movieSessionService.update(movieSession);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        try {
            MovieSession movieSession = movieSessionService.get(id);
            movieSessionService.delete(movieSession);
        } catch (NoSuchElementException e) {
            throw new MovieSessionNotFoundException(
                    "Can't find movie session by id " + id, e);
        }
    }
}
