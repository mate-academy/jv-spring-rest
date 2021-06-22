package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.request.CinemaHallRequestDto;
import mate.academy.spring.dto.response.CinemaHallResponseDto;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.mapper.CinemaHallDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallDtoMapper cinemaHallDtoMapper;
    private final CinemaHallService cinemaHallService;

    public CinemaHallController(CinemaHallDtoMapper cinemaHallDtoMapper,
                                CinemaHallService cinemaHallService) {
        this.cinemaHallDtoMapper = cinemaHallDtoMapper;
        this.cinemaHallService = cinemaHallService;
    }

    @PostMapping
    public CinemaHallResponseDto add(@RequestBody CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall cinemaHall = cinemaHallDtoMapper.parseToModel(cinemaHallRequestDto);
        return cinemaHallDtoMapper.parseToDto(cinemaHallService.add(cinemaHall));
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallDtoMapper::parseToDto)
                .collect(Collectors.toList());
    }

}
