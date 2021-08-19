package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.CinemaHalRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.CinemaHallDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService service;
    private final CinemaHallDtoMapper mapper;

    public CinemaHallController(CinemaHallService service, CinemaHallDtoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public CinemaHallResponseDto post(@RequestBody CinemaHalRequestDto dto) {
        CinemaHall cinemaHall = service.add(mapper.toHall(dto));
        return mapper.parse(cinemaHall);
    }

    @GetMapping
    public List<CinemaHallResponseDto> get() {
        return service.getAll().stream()
                .map(mapper::parse)
                .collect(Collectors.toList());
    }
}
