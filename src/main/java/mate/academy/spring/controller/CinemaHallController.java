package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.CinemaHallDtoRequest;
import mate.academy.spring.model.dto.CinemaHallDtoResponse;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.CinemaHallDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallDtoMapper cinemaHallDtoMapper;
    private final CinemaHallService cinemaHallService;

    @Autowired
    public CinemaHallController(CinemaHallDtoMapper cinemaHallDtoMapper,
                                CinemaHallService cinemaHallService) {
        this.cinemaHallDtoMapper = cinemaHallDtoMapper;
        this.cinemaHallService = cinemaHallService;
    }

    @GetMapping
    public List<CinemaHallDtoResponse> getAll() {
        return cinemaHallService.getAll()
                .stream()
                .map(cinemaHallDtoMapper::parse)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CinemaHallDtoResponse create(@RequestBody CinemaHallDtoRequest cinemaHall) {
        return cinemaHallDtoMapper
                .parse(cinemaHallService.add(cinemaHallDtoMapper.toModel(cinemaHall)));
    }
}
