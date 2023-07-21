package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.request.CinemaHallRequestDto;
import mate.academy.spring.model.dto.response.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.CinemaHallDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaHallController {
    private CinemaHallService cinemaHallService;
    private CinemaHallDtoMapper dtoMapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallDtoMapper dtoMapper) {
        this.cinemaHallService = cinemaHallService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/cinema-halls")
    public List<CinemaHallResponseDto> getAllCinemaHalls() {
        return cinemaHallService.getAll().stream()
                .map(dtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/cinema-halls")
    public CinemaHallResponseDto addCinemaHall(@RequestBody CinemaHallRequestDto cinemaHall) {
        return dtoMapper.toDto(cinemaHallService.add(dtoMapper.toModel(cinemaHall)));
    }
}
