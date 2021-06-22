package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionDtoMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionDtoMapper movieSessionDtoMapper;
    
    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionDtoMapper movieSessionDtoMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionDtoMapper = movieSessionDtoMapper;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public MovieSessionResponseDto add(MovieSessionRequestDto movieSessionRequestDto) {
        return movieSessionDtoMapper.parse(movieSessionService
                .add(movieSessionDtoMapper.toModel(movieSessionRequestDto)));
    }
    
    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAvailableMovieSessions(@RequestParam Long movieId,
                                                                   @RequestParam @DateTimeFormat
                                                                           (pattern = "dd.MM.yyyy")
                                                                           LocalDate localDate) {
        return movieSessionService.findAvailableSessions(movieId, localDate).stream()
                .map(movieSessionDtoMapper::parse).collect(Collectors.toList());
    }
    
    @RequestMapping(name = "/{id}", method = RequestMethod.PUT)
    public MovieSessionResponseDto update(@PathVariable Long id) {
        return movieSessionDtoMapper.parse(movieSessionService.update(movieSessionService.get(id)));
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public MovieSessionResponseDto remove(@PathVariable Long id) {
        return movieSessionDtoMapper.parse(movieSessionService.delete(movieSessionService.get(id)));
    }
}
