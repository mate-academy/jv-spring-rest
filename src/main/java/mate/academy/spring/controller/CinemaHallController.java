package mate.academy.spring.controller;

import mate.academy.spring.dto.cinemaHall.CinemaHallRequestDto;
import mate.academy.spring.dto.cinemaHall.CinemaHallResponseDto;
import mate.academy.spring.model.mapper.CinemaHallMapper;
import mate.academy.spring.service.CinemaHallService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CinemaHallController {
private final CinemaHallService cinemaHallService;
private final CinemaHallMapper cinemaHallMapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallMapper cinemaHallMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallMapper = cinemaHallMapper;
    }

    @PostMapping("/cinema-halls")
    public CinemaHallResponseDto create(@RequestBody CinemaHallRequestDto requestDto) {
        return cinemaHallMapper.parse(cinemaHallService.add(cinemaHallMapper.toModel(requestDto)));
    }

    @GetMapping("/cinema-halls")
    public List<CinemaHallResponseDto> getAllCinemaHalls() {
        return cinemaHallService.getAll()
                .stream()
                .map(cinemaHallMapper::parse).collect(Collectors.toList());
    }
}
