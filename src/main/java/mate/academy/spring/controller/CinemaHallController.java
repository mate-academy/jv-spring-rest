package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.CinemaHallDto;
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
    private final CinemaHallService cinemaHallService;
    private final CinemaHallDtoMapper cinemaHallDtoMapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallDtoMapper cinemaHallDtoMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallDtoMapper = cinemaHallDtoMapper;
    }

    @GetMapping("/")
    public List<CinemaHallDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallDtoMapper::parse)
                .collect(Collectors.toList());
    }

    @PostMapping()
    public CinemaHallDto create(@RequestBody CinemaHallDto cinemaHallDto) {
        return cinemaHallDtoMapper.parse(cinemaHallService
                .add(cinemaHallDtoMapper.toModel(cinemaHallDto)));
    }
}
