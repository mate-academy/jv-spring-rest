package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.CinemaHallDto;
import mate.academy.spring.dto.mapper.impl.CinemaHallMapper;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.service.CinemaHallService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    @ResponseStatus(code = HttpStatus.CREATED)
    public CinemaHallDto add(@RequestBody CinemaHallDto dto) {
        CinemaHall cinemaHall = cinemaHallService.add(cinemaHallMapper.toModel(dto));
        return cinemaHallMapper.toDto(cinemaHall);
    }

    @GetMapping
    public List<CinemaHallDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallMapper::toDto)
                .collect(Collectors.toList());
    }
}
