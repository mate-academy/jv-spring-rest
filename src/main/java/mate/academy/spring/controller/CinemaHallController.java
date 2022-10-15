package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.CinemaHallResponseDto;
import mate.academy.spring.mapper.CinemaHallMapper;
import mate.academy.spring.service.CinemaHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema_halls")
public class CinemaHallController {
    private CinemaHallService cinemaHallService;
    private CinemaHallMapper cinemaHallMapper;

    @Autowired
    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallMapper cinemaHallMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallMapper = cinemaHallMapper;
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll()
                .stream()
                .map(cinemaHallMapper::toDto)
                .collect(Collectors.toList());
    }

}
