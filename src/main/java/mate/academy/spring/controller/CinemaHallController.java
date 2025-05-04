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

    @Autowired
    private CinemaHallService cinemaHallService;

    @Autowired
    private CinemaHallDtoMapper cinemaHallDtoMapper;

    @PostMapping
    public CinemaHallRequestDto create(@RequestBody CinemaHallRequestDto cinemaHall) {
        cinemaHallService.add(cinemaHallDtoMapper.toModel(cinemaHall));
        return cinemaHall;
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll()
                .stream()
                .map(cinemaHall -> cinemaHallDtoMapper.toDto(cinemaHall))
                .collect(Collectors.toList());
    }
}
