package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.impl.MovieSessionDtoMapper;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/available")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public List<MovieSessionResponseDto> getAll(@RequestParam Long movieId,
                                                @DateTimeFormat(pattern = "dd.MM.yyyy")
                                                LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(movieSessionDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public MovieSessionResponseDto create(
            @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        System.out.println("jj");
        return movieSessionDtoMapper.toDto(
                movieSessionService.add(
                        movieSessionDtoMapper.toModel(movieSessionRequestDto)));
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody MovieSessionRequestDto
                                                  movieSessionRequestDto) {
        MovieSession movieSessionDto = movieSessionDtoMapper.toModel(movieSessionRequestDto);
        movieSessionDto.setId(id);
        return movieSessionDtoMapper.toDto(movieSessionService.update(movieSessionDto));

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(movieSessionService.get(id));
    }
}
