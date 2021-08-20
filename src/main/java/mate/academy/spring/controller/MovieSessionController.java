package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.moviesession.MovieSessionRequestDto;
import mate.academy.spring.model.dto.moviesession.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class MovieSessionController {
    private final MovieSessionService service;
    private final MovieSessionMapper mapper;

    public MovieSessionController(MovieSessionService service,
            MovieSessionMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public MovieSessionResponseDto add(@RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        return mapper.parse(service.add(mapper.parse(movieSessionRequestDto)));
    }

    @GetMapping("/")
    public List<MovieSessionResponseDto> getAll(@RequestParam Long movieId,
            @RequestParam
            @DateTimeFormat(pattern = "dd.MM.yyyy")
                    LocalDate date) {
        return service.findAvailableSessions(movieId, date)
                .stream()
                .map(mapper::parse)
                .collect(Collectors.toList());
    }
}
