package mate.academy.spring.controller;

import mate.academy.spring.model.dto.CinemaHallRequest;
import mate.academy.spring.model.dto.CinemaHallResponse;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.maper.CinemaHallMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cinema_hall")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;

    private final CinemaHallMapper cinemaHallMapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallMapper cinemaHallMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallMapper = cinemaHallMapper;
    }

    @PostMapping
    public CinemaHallResponse create(@RequestBody CinemaHallRequest cinemaHallRequest) {
        return cinemaHallMapper.pars(cinemaHallService
                .add(cinemaHallMapper.toCinemaHall(cinemaHallRequest)));
    }

    @GetMapping
    public List<CinemaHallResponse> getAll() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallMapper::pars)
                .collect(Collectors.toList());
    }
}
