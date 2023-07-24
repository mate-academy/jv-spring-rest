package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.cinemahall.CinemaHallRequestDto;
import mate.academy.spring.dto.cinemahall.CinemaHallResponseDto;
import mate.academy.spring.mapper.CinemaHallDtoMapper;
import mate.academy.spring.model.CinemaHall;
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
    private final CinemaHallDtoMapper cinemaHallDtoMapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallDtoMapper cinemaHallDtoMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallDtoMapper = cinemaHallDtoMapper;
    }

    @PostMapping
    public CinemaHallResponseDto create(@RequestBody CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = cinemaHallDtoMapper.toModel(cinemaHallRequestDto);
        return cinemaHallDtoMapper.toDto(cinemaHallService.add(cinemaHall));
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        List<CinemaHall> cinemaHalls = cinemaHallService.getAll();
        return cinemaHalls.stream()
                .map(cinemaHallDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
