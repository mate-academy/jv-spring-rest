package mate.academy.spring.controller;

import java.util.List;
import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.mapper.MovieSessionMapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService service;
    private final MovieSessionMapper mapper;

    public MovieSessionController(MovieSessionService service, MovieSessionMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public MovieSessionResponseDto add(@RequestBody MovieSessionRequestDto requestDto) {
        return mapper.toDto(service.add(mapper.toModel(requestDto)));
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAllAvailable()
}
