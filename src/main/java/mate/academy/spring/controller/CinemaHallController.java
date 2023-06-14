package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.CinemaHallRequestDto;
import mate.academy.spring.dto.CinemaHallResponseDto;
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

    private CinemaHallService cinemaHallService;
    private CinemaHallDtoMapper cinemaHallDtoMapper;

    @Autowired
    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallDtoMapper cinemaHallDtoMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallDtoMapper = cinemaHallDtoMapper;
    }

    @PostMapping
    public CinemaHallResponseDto addCinemaHall(@RequestBody CinemaHallRequestDto
                                                            cinemaHallRequestDto) {
        return cinemaHallDtoMapper.modelInDto(cinemaHallService
                .add(cinemaHallDtoMapper.dtoInModel(cinemaHallRequestDto)));
    }

    @GetMapping("/all")
    public List<CinemaHallResponseDto> allCinemaHall() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallDtoMapper::modelInDto)
                .collect(Collectors.toList());
    }

}
