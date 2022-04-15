package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.request.MovieRequestDto;
import mate.academy.spring.model.dto.response.MovieResponseDto;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.parsers.MovieDtoParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService service;
    private final MovieDtoParser parser;

    public MovieController(MovieService service, MovieDtoParser parser) {
        this.service = service;
        this.parser = parser;
    }

    @PostMapping
    public MovieResponseDto add(@RequestBody MovieRequestDto requestDto) {
        Movie entity = service.add(parser.parseRequestToEntity(requestDto));
        return parser.parseEntityToResponse(entity);
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return service.getAll().stream()
                .map(parser::parseEntityToResponse)
                .collect(Collectors.toList());
    }
}
