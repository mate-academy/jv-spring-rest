package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.security.mapper.CinemaHallDtoMapper;
import mate.academy.spring.service.CinemaHallService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaController {
    private final CinemaHallDtoMapper cinemaHallDtoMapper;
    private CinemaHallService cinemaHallService;

    public CinemaController(CinemaHallDtoMapper cinemaHallDtoMapper,
                            CinemaHallService cinemaHallService) {
        this.cinemaHallDtoMapper = cinemaHallDtoMapper;
        this.cinemaHallService = cinemaHallService;
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallDtoMapper::parse)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CinemaHallResponseDto create(@RequestBody CinemaHallRequestDto cinema) {
        return cinemaHallDtoMapper.parse(cinemaHallService
                .add(cinemaHallDtoMapper.toCinemaHall(cinema)));
    }
}
