package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.cinemahall.CinemaHallRequestDto;
import mate.academy.spring.dto.cinemahall.CinemaHallResponseDto;
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
    private final CinemaHallDtoMapper cinemaHallMapper;
    private final CinemaHallService cinemaHallService;

    public CinemaHallController(CinemaHallDtoMapper cinemaHallMapper,
                                CinemaHallService cinemaHallService) {
        this.cinemaHallMapper = cinemaHallMapper;
        this.cinemaHallService = cinemaHallService;
    }

    @PostMapping
    public CinemaHallResponseDto create(@RequestBody CinemaHallRequestDto requestDto) {
        return cinemaHallMapper.toDto(cinemaHallService.add(cinemaHallMapper.toModel(requestDto)));
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallMapper::toDto)
                .collect(Collectors.toList());
    }
}
