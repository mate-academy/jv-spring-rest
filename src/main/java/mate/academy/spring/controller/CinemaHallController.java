package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.model.request.CinemaHallRequestDto;
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
    private final CinemaHallService cinemaHallService;
    private final CinemaHallDtoMapper mapper;

    @Autowired
    public CinemaHallController(CinemaHallService cinemaHallService, CinemaHallDtoMapper mapper) {
        this.cinemaHallService = cinemaHallService;
        this.mapper = mapper;
    }

    @GetMapping()
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream().map(mapper::parse)
                .collect(Collectors.toList());
    }

    @PostMapping()
    public CinemaHallResponseDto add(@RequestBody CinemaHallRequestDto cinemaHall) {
        return mapper.parse(cinemaHallService.add(mapper.toModel(cinemaHall)));
    }
}
