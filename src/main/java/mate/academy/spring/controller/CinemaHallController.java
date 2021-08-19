package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallMapper;
import mate.academy.spring.service.CinemaHallService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService service;
    private final CinemaHallMapper mapper;

    public CinemaHallController(CinemaHallService service, CinemaHallMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public CinemaHallResponseDto create(@RequestBody CinemaHallRequestDto cinemaHallRequestDto) {
        return mapper.parse(service.add(mapper.toModel(cinemaHallRequestDto)));
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAllCinemaHall() {
        return service.getAll()
                .stream()
                .map(mapper::parse)
                .collect(Collectors.toList());
    }
}
