package mate.academy.spring.controller;

import mate.academy.spring.dto.responses.CinemaHallDtoResponse;
import mate.academy.spring.dto.requests.CinemaHallDtoRequest;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.CinemaHallDtoMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private CinemaHallDtoMapper cinemaHallDtoMapper;
    private CinemaHallService cinemaHallService;

    public CinemaHallController(CinemaHallDtoMapper cinemaHallDtoMapper, CinemaHallService cinemaHallService) {
        this.cinemaHallDtoMapper = cinemaHallDtoMapper;
        this.cinemaHallService = cinemaHallService;
    }

    @PostMapping
    public CinemaHallDtoResponse create(@RequestBody CinemaHallDtoRequest cinemaHallDtoRequest) {
       return cinemaHallDtoMapper.parse(cinemaHallService.add(cinemaHallDtoMapper.toModel(cinemaHallDtoRequest)));
    }

    @GetMapping
    public List<CinemaHallDtoResponse> getAllCinemaHalls() {
        return cinemaHallService.getAll()
                .stream()
                .map(cinemaHallDtoMapper::parse)
                .collect(Collectors.toList());
    }
}
