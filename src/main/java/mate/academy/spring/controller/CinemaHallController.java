package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.cinemahall.CinemaHallRequestDto;
import mate.academy.spring.model.dto.cinemahall.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.CinemaHallMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-hall")
public class CinemaHallController {
    private final CinemaHallService service;
    private final CinemaHallMapper mapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
            CinemaHallMapper mapper) {
        this.service = cinemaHallService;
        this.mapper = mapper;
    }

    @PostMapping
    public CinemaHallResponseDto add(@RequestBody CinemaHallRequestDto cinemaHallRequestDto) {
        return mapper.parse(service.add(mapper.parse(cinemaHallRequestDto)));
    }

    @GetMapping("/")
    public List<CinemaHallResponseDto> getAllCinemaHalls() {
        return service
                .getAll()
                .stream()
                .map(p -> mapper.parse(p))
                .collect(Collectors.toList());
    }
}
