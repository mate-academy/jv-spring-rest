package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionMapperDto;
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
    private MovieSessionService movieSessionService;
    private MovieSessionMapperDto mapperDto;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapperDto mapperDto) {
        this.movieSessionService = movieSessionService;
        this.mapperDto = mapperDto;
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAvailable(@RequestParam Long movieId,
                                                @RequestParam
                                                @DateTimeFormat(pattern = "dd.mm.yyyy")
                                                        LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date).stream()
                .map(mapperDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public MovieSessionResponseDto create(@RequestBody MovieSessionRequestDto requestDto) {
        return mapperDto.toDto(movieSessionService.add(mapperDto.toModel(requestDto)));
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody MovieSessionRequestDto requestDto) {
        MovieSession session = mapperDto.toModel(requestDto);
        session.setId(id);
        return mapperDto.toDto(movieSessionService.update(session));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }
}
