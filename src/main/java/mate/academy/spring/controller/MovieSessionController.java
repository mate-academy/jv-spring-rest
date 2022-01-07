package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionDtoMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionDtoMapper movieSessionDtoMapper;

    @PostMapping
    public MovieSessionResponseDto create(@RequestBody MovieSessionRequestDto requestDto) {
        return movieSessionDtoMapper
                .toDto(movieSessionService.add(movieSessionDtoMapper.toModel(requestDto)));
    }

    @GetMapping("/{id}")
    public MovieSessionResponseDto get(@PathVariable Long id) {
        return movieSessionDtoMapper.toDto(movieSessionService.get(id));
    }

    @GetMapping
    public List<MovieSessionResponseDto> getAll() {
        return movieSessionService.getAll().stream()
                .map(movieSessionDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody MovieSessionRequestDto requestDto) {
        MovieSession movieSession = movieSessionDtoMapper.toModel(requestDto);
        movieSession.setId(id);
        return movieSessionDtoMapper.toDto(movieSessionService.get(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }
}
