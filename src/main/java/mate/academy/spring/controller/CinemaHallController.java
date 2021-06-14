package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
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
    private final CinemaHallMapper mapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallMapper mapper) {
        this.cinemaHallService = cinemaHallService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAllCinemaHalls() {
        return cinemaHallService.getAll().stream()
                .map(mapper::parse)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CinemaHallResponseDto add(@RequestBody CinemaHallRequestDto requestDto) {
        return mapper.parse(cinemaHallService.add(mapper.toModel(requestDto)));

    }
}
