package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.RequestCinemaHallDto;
import mate.academy.spring.dto.ResponseCinemaHallDto;
import mate.academy.spring.model.mapper.CinemaHallMapper;
import mate.academy.spring.service.CinemaHallService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallMapper cinemaHallMapper;
    private final CinemaHallService cinemaHallService;

    public CinemaHallController(CinemaHallMapper cinemaHallMapper,
                                CinemaHallService cinemaHallService) {
        this.cinemaHallMapper = cinemaHallMapper;
        this.cinemaHallService = cinemaHallService;
    }

    @GetMapping
    public List<ResponseCinemaHallDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseCinemaHallDto create(@RequestBody RequestCinemaHallDto requestDto) {
        return cinemaHallMapper.toDto(cinemaHallService.add(cinemaHallMapper.toModel(requestDto)));
    }
}
