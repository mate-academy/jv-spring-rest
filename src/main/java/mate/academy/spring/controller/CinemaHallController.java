package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.CinemaHallMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(mapper::parse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CinemaHallResponseDto get(@PathVariable Long id) {
        return mapper.parse(cinemaHallService.get(id));
    }

    @PostMapping
    public CinemaHallResponseDto createCinemaHall(
            @RequestBody CinemaHallRequestDto cinemaHallRequestDto) {
        return mapper.parse(cinemaHallService.add(mapper.toModel(cinemaHallRequestDto)));
    }
}
