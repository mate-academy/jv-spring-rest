package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.CinemaHallRequestDto;
import mate.academy.spring.model.dto.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.CinemaHallDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final CinemaHallDtoMapper dtoMapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallDtoMapper dtoMapper) {
        this.cinemaHallService = cinemaHallService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/cinema_halls")
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(dtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/cinema_halls")
    public CinemaHallResponseDto save(@RequestBody CinemaHallRequestDto dto) {
        return dtoMapper.toDto(cinemaHallService.add(dtoMapper.toModel(dto)));
    }
}
