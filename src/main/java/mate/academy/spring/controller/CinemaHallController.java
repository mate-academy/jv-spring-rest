package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.CinemaHallRequest;
import mate.academy.spring.model.dto.CinemaHallResponse;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.maper.CinemaHallMapper;
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

    @PostMapping
    public CinemaHallResponse create(@RequestBody CinemaHallRequest cinemaHallRequest) {
        return cinemaHallMapper.toDto(cinemaHallService
                .add(cinemaHallMapper.toModel(cinemaHallRequest)));
    }

    @GetMapping
    public List<CinemaHallResponse> getAll() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallMapper::toDto)
                .collect(Collectors.toList());
    }
}
