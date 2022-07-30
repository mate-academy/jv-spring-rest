package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.dtomapper.CinemaHallDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final CinemaHallDtoMapper hallDtoMapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallDtoMapper hallDtoMapper) {
        this.cinemaHallService = cinemaHallService;
        this.hallDtoMapper = hallDtoMapper;
    }

    @PostMapping
    public CinemaHallResponseDto add(@RequestBody CinemaHallRequestDto cinemaHall) {
        return hallDtoMapper.toDto(cinemaHallService.add(hallDtoMapper.toModel(cinemaHall)));
    }

    @GetMapping
    List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(hallDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
