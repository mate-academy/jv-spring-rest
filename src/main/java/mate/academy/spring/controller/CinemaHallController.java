package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.request.CinemaHallRequestDto;
import mate.academy.spring.model.dto.response.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.parsers.CinemaHallDtoParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {

    private final CinemaHallService service;
    private final CinemaHallDtoParser parser;

    public CinemaHallController(CinemaHallService service, CinemaHallDtoParser parser) {
        this.service = service;
        this.parser = parser;
    }

    @PostMapping
    public CinemaHallResponseDto add(@RequestBody CinemaHallRequestDto requestDto) {
        CinemaHall entity = service.add(parser.parseRequestToEntity(requestDto));
        return parser.parseEntityToResponse(entity);
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return service.getAll().stream()
                .map(parser::parseEntityToResponse)
                .collect(Collectors.toList());
    }
}
