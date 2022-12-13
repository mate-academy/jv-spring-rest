package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
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
    private final CinemaHallService hallService;
    private final CinemaHallMapper hallMapper;

    public CinemaHallController(CinemaHallService hallService, CinemaHallMapper hallMapper) {
        this.hallService = hallService;
        this.hallMapper = hallMapper;
    }

    @PostMapping
    public CinemaHallResponseDto add(@RequestBody CinemaHallRequestDto cinemaHallDto) {
        return hallMapper.toDto(hallService
                .add(hallMapper.toModel(cinemaHallDto)));
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return hallService.getAll().stream()
                .map(hallMapper::toDto)
                .collect(Collectors.toList());
    }
}
