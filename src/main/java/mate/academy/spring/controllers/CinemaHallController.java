package mate.academy.spring.controllers;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.CinemaHallDtoRequest;
import mate.academy.spring.model.dto.CinemaHallDtoResponse;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.CinemaHallMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final CinemaHallMapper cinemaHallMapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallMapper cinemaHallMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallMapper = cinemaHallMapper;
    }

    @GetMapping
    public List<CinemaHallDtoResponse> getAllCinemaHalls() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CinemaHallDtoResponse create(@RequestBody CinemaHallDtoRequest cinemaHallDtoRequest) {
        return cinemaHallMapper.toDto(cinemaHallService.add(
                cinemaHallMapper.toModel(cinemaHallDtoRequest)));
    }
}
