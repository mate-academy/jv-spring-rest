package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.MovieSessionDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionMapper movieSessionMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapper movieSessionMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @PostMapping
    public MovieSessionDto add(@RequestBody MovieSessionDto movieSessionDto) {
        return movieSessionMapper.mapToDto(movieSessionService.add(
                movieSessionMapper.mapToModel(movieSessionDto)
        ));
    }

    @GetMapping("/available")
    @ResponseBody
    public List<MovieSessionDto> get(@RequestParam Long movieId,
                                     @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy")
                                             LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(movieSessionMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @ResponseBody
    public MovieSessionDto update(@PathVariable Long id,
                                  @RequestBody MovieSessionDto movieSessionDto) {
        movieSessionDto.setId(id);
        return movieSessionMapper.mapToDto(
                movieSessionService.update(movieSessionMapper.mapToModel(movieSessionDto))
        );
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }
}
