package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.dto.CinemaHallRequestDto;
import mate.academy.spring.service.dto.CinemaHallResponseDto;
import mate.academy.spring.service.mappers.CinemaHallMapper;
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
    private CinemaHallService cinemaHallService;
    private CinemaHallMapper cinemaHallMapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallMapper cinemaHallMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallMapper = cinemaHallMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CinemaHallResponseDto addCinemaHall(@RequestBody
                                 CinemaHallRequestDto cinemaHallRequestDto) {
        return cinemaHallMapper.parseEntityToDto(cinemaHallService
                .add(cinemaHallMapper.parseDtoToEntity(cinemaHallRequestDto)));
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAllCinemaHalls() {
        return cinemaHallService.getAll()
                .stream()
                .map(i -> cinemaHallMapper.parseEntityToDto(i))
                .collect(Collectors.toList());
    }
}
