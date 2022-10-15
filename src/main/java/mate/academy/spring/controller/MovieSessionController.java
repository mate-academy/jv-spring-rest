package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.mapper.MovieSessionMapper;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private MovieSessionService movieSessionService;
    private MovieSessionMapper movieSessionMapper;

    @Autowired
    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapper movieSessionMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @PostMapping
    public MovieSessionResponseDto create(@RequestBody MovieSessionRequestDto requestDto) {
        return movieSessionMapper.toDto(movieSessionService.add(movieSessionMapper.toModel(requestDto)));
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAllAvailable(@RequestParam("movieId") Long movieId,
                                                         @RequestParam
                                              @DateTimeFormat(pattern = "dd.MM.yyyy")
                                                         LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(movieSessionMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody MovieSessionRequestDto requestDto) {
        return movieSessionMapper
                .toDto();
    }

}
