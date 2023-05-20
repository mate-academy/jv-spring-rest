package mate.academy.spring.controller;

import mate.academy.spring.dto.cinemaHall.CinemaHallRequestDto;
import mate.academy.spring.dto.cinemaHall.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.CinemaHallDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final CinemaHallDtoMapper cinemaHallDtoMapper;

    @Autowired
    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallDtoMapper cinemaHallDtoMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallDtoMapper = cinemaHallDtoMapper;
    }


    @GetMapping
    public List<CinemaHallResponseDto> cinemaHalls() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallDtoMapper::parseCinemaHall)
                .collect(Collectors.toList());
    }

    @PostMapping()
    public CinemaHallResponseDto create(@RequestBody CinemaHallRequestDto cinemaHall) {
        return cinemaHallDtoMapper.parseCinemaHall(cinemaHallService
                .add(cinemaHallDtoMapper.toModel(cinemaHall)));
    }
}
