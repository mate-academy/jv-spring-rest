package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.CinemaHallDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaHallController {
    private final CinemaHallDtoMapper mapper;
    private final CinemaHallService service;

    public CinemaHallController(CinemaHallDtoMapper mapper, CinemaHallService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping("/cinema-halls")
    public List<CinemaHallResponseDto> getAllCinemaHalls() {
        return service.getAll().stream().map(mapper::parse).collect(Collectors.toList());
    }

    @PostMapping("/cinema-halls")
    public CinemaHallResponseDto create(@RequestBody CinemaHallRequestDto cinemaHallRequestDto) {
        return mapper.parse(service.add(mapper.toModel(cinemaHallRequestDto)));
    }
}
