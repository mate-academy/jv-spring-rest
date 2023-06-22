package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.CinemaHallRequestMapper;
import mate.academy.spring.mapper.CinemaHallResponseMapper;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final CinemaHallRequestMapper cinemaHallRequestMapper;
    private final CinemaHallResponseMapper cinemaHallResponseMapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallRequestMapper cinemaHallRequestMapper,
                                CinemaHallResponseMapper cinemaHallResponseMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallRequestMapper = cinemaHallRequestMapper;
        this.cinemaHallResponseMapper = cinemaHallResponseMapper;
    }

    @PostMapping
    public CinemaHallResponseDto add(@RequestBody CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = cinemaHallService
                .add(cinemaHallRequestMapper.fromDto(cinemaHallRequestDto));
        return cinemaHallResponseMapper.toDto(cinemaHall);
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
