package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.CinemaHallMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final CinemaHallMapper mapper;

    @Autowired
    public CinemaHallController(CinemaHallService cinemaHallService, CinemaHallMapper mapper) {
        this.cinemaHallService = cinemaHallService;
        this.mapper = mapper;
    }

    @GetMapping("/cinema-halls")
    public List<CinemaHallResponseDto> getAllCinemaHalls() {
        return cinemaHallService.getAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/cinema-halls")
    public CinemaHallResponseDto create(@RequestBody CinemaHallRequestDto cinemaHall) {
        return mapper.toDto(cinemaHallService.add(mapper.toModel(cinemaHall)));
    }
}
