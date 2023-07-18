package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.cinema.hall.CinemaHallRequestDto;
import mate.academy.spring.dto.cinema.hall.CinemaHallResponseDto;
import mate.academy.spring.mapper.CinemaHallDtoMapper;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.service.CinemaHallService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema_halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final CinemaHallDtoMapper mapper;

    public CinemaHallController(CinemaHallService cinemaHallService, CinemaHallDtoMapper mapper) {
        this.cinemaHallService = cinemaHallService;
        this.mapper = mapper;
    }

    @PostMapping
    public CinemaHallResponseDto create(@RequestBody CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHallModel = mapper.toModel(cinemaHallRequestDto);
        return mapper.toDto(cinemaHallService.add(cinemaHallModel));
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                 .map(mapper::toDto)
                 .collect(Collectors.toList());
    }
}
