package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.CinemaDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final CinemaDtoMapper cinemaDtoMapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
            CinemaDtoMapper cinemaDtoMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaDtoMapper = cinemaDtoMapper;
    }

    @GetMapping("/")
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll()
            .stream()
            .map(cinemaDtoMapper::toDto)
            .collect(Collectors.toList());
    }

    @PostMapping("/")
    public CinemaHallResponseDto create(@RequestBody CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = cinemaDtoMapper.toModel(cinemaHallRequestDto);
        return cinemaDtoMapper.toDto(cinemaHallService.add(cinemaHall));
    }

}
